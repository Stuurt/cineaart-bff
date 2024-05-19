package com.filtec.domain.queue;

import com.filtec.domain.enums.QueueEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Component
public class QueuePublisher {
    private final RabbitTemplate rabbitTemplate;

    public void publishTicket(String ticket) {
        Message message = MessageBuilder
                .withBody(ticket.getBytes(StandardCharsets.UTF_8))
                .setContentType("text/plain")
                .setCorrelationId(generateCorrelationId())
                .build();
        rabbitTemplate.send(
                QueueEnum.TICKET_QUEUE.getQueueName(),
                message
        );
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }
}
