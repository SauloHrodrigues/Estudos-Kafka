package com.exemplo.kafka.pub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
public class PubServer {

    @Autowired
    private KafkaTemplate<String,String> producerTemplate;

    public void send(String eventMensage){
        System.out.println("Mensage: " + eventMensage);
        producerTemplate.send(new GenericMessage<>(eventMensage));
    }
}
