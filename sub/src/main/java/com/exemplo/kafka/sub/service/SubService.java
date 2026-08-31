package com.exemplo.kafka.sub.service;

import com.exemplo.kafka.sub.model.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class SubService {
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "MY.TEST.TOPIC.1", groupId = "my-group-id")
    public void consumer(String eventMessage) {
        JsonNode jsonNode = objectMapper.readTree(eventMessage);
        JsonMessage message =  objectMapper.treeToValue(jsonNode, JsonMessage.class);
        System.out.println("Recebido: " + message.toString());
    }


}
