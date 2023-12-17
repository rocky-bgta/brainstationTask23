package com.salahin.rocky.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Slf4j
public class UserEventConsumer {

    @KafkaListener(topics = "user-event", groupId = "user_event_consumer_group")
    public void userEventConsumer1(String userEvent) {
        log.info("userEventConsumer1 consumed message {} ", userEvent);
    }

    @KafkaListener(topics = "user-event", groupId = "user_event_consumer_group")
    public void userEventConsumer2(String userEvent){
        log.info("userEventConsumer2 consumed message {} ", userEvent);
    }

    @KafkaListener(topics = "user-event", groupId = "user_event_consumer_group")
    public void userEventConsumer3(String userEvent){
        log.info("userEventConsumer3 consumed message {} ", userEvent);
    }
}
