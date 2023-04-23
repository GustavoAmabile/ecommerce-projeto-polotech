package com.ecommerce.projetotestes.exception;



public class RegistroDuplicadoException extends RuntimeException{

        public RegistroDuplicadoException() {
            super("Registro já cadastrado!");
        }


}
