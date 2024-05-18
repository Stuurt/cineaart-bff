package com.filtec.rest.controller;

import com.filtec.domain.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    @PostMapping("/tickets")
    public ResponseEntity<Void> createTicket()  {
        ticketService.createTicket("test");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
