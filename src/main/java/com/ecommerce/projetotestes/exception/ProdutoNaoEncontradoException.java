package com.ecommerce.projetotestes.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{

            public ProdutoNaoEncontradoException() {
                super("Produto não encontrado!");
            }
}
