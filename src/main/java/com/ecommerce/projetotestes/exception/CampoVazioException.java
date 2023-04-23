package com.ecommerce.projetotestes.exception;

public class CampoVazioException extends RuntimeException{

    public CampoVazioException() {
        super("Campo vazio!");
    }
}
