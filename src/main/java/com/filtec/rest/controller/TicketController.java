package com.filtec.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filtec.domain.service.TicketService;
import com.filtec.rest.request.TicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    @PostMapping("/tickets")
    public ResponseEntity<Void> createTicket(@RequestBody TicketRequest ticketRequest) throws JsonProcessingException {
        ticketService.createTicket(ticketRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
