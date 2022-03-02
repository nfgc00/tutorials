package com.nfgc.mq.service;

import com.nfgc.mq.config.MQConfig;
import com.nfgc.mq.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Message message) {
        log.info("Message from Queue: {}", message);
    }
}
