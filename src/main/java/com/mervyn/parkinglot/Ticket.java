package com.mervyn.parkinglot;

import lombok.Data;

import java.util.UUID;

@Data
public class Ticket {
    private String token;

    public Ticket() {
        buildToken();
    }

    private void buildToken() {
        this.token = UUID.randomUUID().toString();
    }
}
