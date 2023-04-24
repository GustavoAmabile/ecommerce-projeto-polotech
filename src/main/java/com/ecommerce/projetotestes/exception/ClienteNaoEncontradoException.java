package com.ecommerce.projetotestes.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

        public ClienteNaoEncontradoException() {
            super("Cliente não encontrado!");
        }
}
