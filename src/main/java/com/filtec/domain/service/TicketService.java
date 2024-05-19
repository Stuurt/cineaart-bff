package com.filtec.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filtec.domain.queue.QueuePublisher;
import com.filtec.rest.request.TicketRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final Logger log = LoggerFactory.getLogger(TicketService.class);

    private final QueuePublisher queuePublisher;

    public void createTicket(TicketRequest ticket) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var ticketJson = objectMapper.writeValueAsString(ticket);
        log.info("sending new ticket to the queue: [" + ticketJson + "]");
        queuePublisher.publishTicket(ticketJson);
    }
}
