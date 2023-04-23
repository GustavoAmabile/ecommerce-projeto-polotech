package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.model.Produto;
import com.ecommerce.projetotestes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto getProduto(Long idProduto) {
        return produtoRepository.findById(idProduto).get();
    }
}
