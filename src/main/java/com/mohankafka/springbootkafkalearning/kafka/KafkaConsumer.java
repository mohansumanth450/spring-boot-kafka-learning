package com.mohankafka.springbootkafkalearning.kafka;

import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mohankafka.springbootkafkalearning.payload.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "mohan-topic-json", groupId = "MohanConsumerGroup-JSON")
    public void consumeMessagee(String payload) {
        log.info("User Json Consumed message: {}", payload);
    }

    @KafkaListener(topics = "mohan-topic", groupId = "MohanConsumerGroup")
    public void consumeMessage(String message) {
        log.info("String Consumed message: {}", message);
    }

}
