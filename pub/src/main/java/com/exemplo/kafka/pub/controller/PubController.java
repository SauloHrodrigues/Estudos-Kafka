package com.exemplo.kafka.pub.controller;

import com.exemplo.kafka.pub.service.PubServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubController {

    @Autowired
    private PubServer pubServer;

    @PostMapping("/publish/text")
    public void publishText(@RequestBody String text){
        System.out.println("Request received: "+text);
        pubServer.send(text);
    }
}
