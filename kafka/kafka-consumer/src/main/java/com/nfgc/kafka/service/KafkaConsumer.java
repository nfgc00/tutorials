package com.nfgc.kafka.service;

import com.nfgc.kafka.config.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = KafkaConfig.TOPIC, groupId = KafkaConfig.GROUP_ID)
    public void consume(String message) {
        log.info("Message: {}", message);
    }
}
