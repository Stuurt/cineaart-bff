package com.filtec.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filtec.domain.service.CinemaService;
import com.filtec.rest.dto.PagedResource;
import com.filtec.rest.dto.Session;
import com.filtec.rest.dto.request.SessionCreateRequest;
import com.filtec.rest.dto.request.TicketRequest;
import com.filtec.rest.dto.response.SessionListResponse;
import com.filtec.rest.dto.response.SessionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cinema")
@CrossOrigin(origins = "*")
public class CinemaController {
    private final CinemaService cinemaService;

    @PostMapping("/tickets")
    public ResponseEntity<Void> createTicket(@RequestBody TicketRequest ticketRequest) throws JsonProcessingException {
        cinemaService.createTicket(ticketRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/movies/{movieId}/rooms/{roomId}/sessions")
    public ResponseEntity<Session> createSession(
            @RequestBody SessionCreateRequest request,
            @PathVariable Long movieId,
            @PathVariable Long roomId
    ) {
        return cinemaService.createSession(request, movieId, roomId);
    }

    @GetMapping("/sessions")
    public ResponseEntity<PagedResource<SessionListResponse>> getAllSessions() {
        return cinemaService.getAllSessions();
    }

    @GetMapping("/sessions/{sessionId}")
    public ResponseEntity<SessionResponse> getSession(
            @PathVariable String sessionId,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        return cinemaService.getSession(sessionId, page, size);
    }
}
