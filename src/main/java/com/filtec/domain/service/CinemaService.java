package com.filtec.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filtec.domain.queue.QueuePublisher;
import com.filtec.rest.client.CinemaClient;
import com.filtec.rest.dto.PagedResource;
import com.filtec.rest.dto.Session;
import com.filtec.rest.dto.request.SessionCreateRequest;
import com.filtec.rest.dto.request.TicketRequest;
import com.filtec.rest.dto.response.SessionListResponse;
import com.filtec.rest.dto.response.SessionResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CinemaService {
    private final Logger log = LoggerFactory.getLogger(CinemaService.class);

    private final CinemaClient cinemaClient;
    private final QueuePublisher queuePublisher;

    public ResponseEntity<Session> createSession(SessionCreateRequest request, Long movieId, Long roomId) {
        return cinemaClient.createSession(request, movieId, roomId);
    }

    public ResponseEntity<PagedResource<SessionListResponse>> getAllSessions() {
        return cinemaClient.getAllSessions();
    }

    public ResponseEntity<SessionResponse> getSession(String sessionId, int page, int size) {
        return cinemaClient.getSession(sessionId, page, size);
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
