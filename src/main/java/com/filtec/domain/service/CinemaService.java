package com.filtec.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filtec.domain.queue.QueuePublisher;
import com.filtec.rest.client.CinemaClient;
import com.filtec.rest.dto.PagedResource;
import com.filtec.rest.dto.Session;
import com.filtec.rest.dto.request.MovieCreateRequest;
import com.filtec.rest.dto.request.SessionCreateRequest;
import com.filtec.rest.dto.request.TicketRequest;
import com.filtec.rest.dto.response.MovieListResponse;
import com.filtec.rest.dto.response.MovieResponse;
import com.filtec.rest.dto.response.SessionListResponse;
import com.filtec.rest.dto.response.SessionResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CinemaService {
    private final Logger log = LoggerFactory.getLogger(CinemaService.class);
    private final CinemaClient cinemaClient;
    private final QueuePublisher queuePublisher;

    public byte[] getMovieImage(Long movieId) {
        return cinemaClient.getMovieImage(movieId);
    }

    public void saveMovieImage(Long movieId, MultipartFile[] image) {
        cinemaClient.saveMovieImage(image, movieId);
    }

    public ResponseEntity<MovieResponse> createMovie(MovieCreateRequest movieCreateRequest) {
        return cinemaClient.createMovie(movieCreateRequest);
    }

    public ResponseEntity<MovieResponse> getMovieById(Long movieId) {
        return cinemaClient.getMovieById(movieId);
    }

    public ResponseEntity<PagedResource<MovieListResponse>> getMoviePage(Integer page, Integer size) {
        return cinemaClient.getAllMoviePaginated(page, size);
    }

    public ResponseEntity<Session> createSession(SessionCreateRequest request, Long movieId, Long roomId) {
        return cinemaClient.createSession(request, movieId, roomId);
    }

    public ResponseEntity<PagedResource<SessionListResponse>> getSessionPage(int page, int size) {
        return cinemaClient.getSessionPage(page, size);
    }

    public ResponseEntity<PagedResource<SessionListResponse>> getSessionPageByMovieId(Long movieId, int page, int size) {
        return cinemaClient.getSessionPageByMovieId(movieId, page, size);
    }

    public ResponseEntity<SessionResponse> getSessionById(Long sessionId) {
        return cinemaClient.getSession(sessionId);
    }

    public void createTicket(TicketRequest ticket) throws JsonProcessingException {
        cinemaClient.updateSeatToUnavailable(ticket.getSeatId());
        ObjectMapper objectMapper = new ObjectMapper();
        var ticketJson = objectMapper.writeValueAsString(ticket);
        var correlationId = ticket.getUuid().toString();
        log.info("sending new ticket to the queue: [" + ticketJson + "]");
        queuePublisher.publishTicket(ticketJson, correlationId);
    }
}
