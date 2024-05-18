package com.filtec.domain.queue;

import com.filtec.domain.enums.QueueEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class QueuePublisher {
    private final RabbitTemplate rabbitTemplate;

    public void publishTicket(String ticket) {
        rabbitTemplate.convertAndSend(
                QueueEnum.TICKET_QUEUE.getQueueName(),
                ticket
        );
    }
}
