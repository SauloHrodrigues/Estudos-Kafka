package com.exemplo.kafka.sub.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JsonMessage {
    private String nome;
    private String cpf;

}
