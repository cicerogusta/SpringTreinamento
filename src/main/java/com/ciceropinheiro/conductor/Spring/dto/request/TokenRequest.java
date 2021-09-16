package com.ciceropinheiro.conductor.Spring.dto.request;

public class TokenRequest {
    private String token;
    private String tipo;

    public TokenRequest(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
}
