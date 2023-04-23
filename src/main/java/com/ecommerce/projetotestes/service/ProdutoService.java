package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.model.Produto;
import com.ecommerce.projetotestes.model.dao.ProdutoDAO;
import com.ecommerce.projetotestes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class ProdutoService {


    private ProdutoDAO produtoDAO;

    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public List<Produto> getProdutos() {
        return produtoDAO.findAll();
    }


}


