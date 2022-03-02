package com.nfgc.mq.controller;

import com.nfgc.mq.config.MQConfig;
import com.nfgc.mq.message.Message;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class PublisherController {

    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publish(@RequestBody Message message) {
        message.setId(UUID.randomUUID().toString());
        message.setDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
        return "Message Published.";
    }
}
