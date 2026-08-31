package com.exemplo.kafka.pub.service;

import com.exemplo.kafka.pub.model.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.exc.JsonNodeException;

@Service
public class PubServer {

    @Autowired
    private KafkaTemplate<String,String> producerTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public void send(String eventMensage){
        System.out.println("Mensage: " + eventMensage);
        JsonMessage jsonMessage = (JsonMessage) jsonNodeToObject(eventMensage, JsonMessage.class);
        producerTemplate.send(new GenericMessage<>(objectToJsonNode(jsonMessage)));
    }

    private Object jsonNodeToObject(String jsonString, Class<?> clazz){
        try {
            return objectMapper.readValue(jsonString,clazz);
        } catch (JsonNodeException e){
            throw  new RuntimeException(e);
        }
    }

    private JsonNode objectToJsonNode(Object object){
        return objectMapper.valueToTree(object);
    }
}
