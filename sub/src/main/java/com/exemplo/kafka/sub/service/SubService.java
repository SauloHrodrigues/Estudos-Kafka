package com.exemplo.kafka.sub.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SubService {

    @KafkaListener(topics = "MY.TEST.TOPIC.1", groupId = "my-group-id")
    public void consumer(String eventMessage){
        System.out.println("Recebido: " + eventMessage);
    }


}
