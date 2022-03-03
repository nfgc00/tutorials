package com.nfgc.kafka.controller;

import com.nfgc.kafka.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class ProducerController {

    public static final String TOPIC = "NewTopic";
    private KafkaTemplate<String, Book> kafkaTemplate;

    @PostMapping("/publish")
    public String publish(@RequestBody Book book) {
        kafkaTemplate.send(TOPIC, book);
        return "Book Published Successfully.";
    }

    @GetMapping("/publish/{message}")
    public String publish(@PathVariable String message) {
//        kafkaTemplate.send(TOPIC, message);
        return "Published Successfully.";
    }
}
