package com.exemplo.kafka.pub.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JsonMessage {
    private String nome;
    private String cpf;

}
