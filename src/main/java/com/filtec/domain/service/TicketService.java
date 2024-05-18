package com.filtec.domain.service;

import com.filtec.domain.queue.QueuePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final QueuePublisher queuePublisher;

    public void createTicket(String ticket) {
        queuePublisher.publishTicket(ticket);
    }
}
