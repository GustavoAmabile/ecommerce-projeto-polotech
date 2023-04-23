package com.ecommerce.projetotestes.exception;

public class ProdutoNotFoundException extends RuntimeException{

        public ProdutoNotFoundException(Long id) {
            super("Produto não encontrado: " + id);
        }
}
