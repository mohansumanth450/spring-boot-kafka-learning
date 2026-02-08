package com.mohankafka.springbootkafkalearning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohankafka.springbootkafkalearning.kafka.JsonKafkaProducer;
import com.mohankafka.springbootkafkalearning.kafka.KafkaProducer;
import com.mohankafka.springbootkafkalearning.payload.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String topic, @RequestParam String message) {
        kafkaProducer.sendMessage(topic, message);
        return ResponseEntity.ok("Message published to topic: " + topic);
    }

    @PostMapping("/publishJsonMessage")
    public ResponseEntity<String> publishJson(@RequestParam String topic, @RequestBody User user) {
        jsonKafkaProducer.sendMessage(topic, user);
        return ResponseEntity.ok("JSON Message published to topic: " + topic);
    }

}
