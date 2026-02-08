package com.mohankafka.springbootkafkalearning.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mohankafka.springbootkafkalearning.payload.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "mohan-topic", groupId = "MohanConsumerGroup")
    public void consumeMessage(User message) {
        log.info("Consumed message: {}", message);
    }

}
