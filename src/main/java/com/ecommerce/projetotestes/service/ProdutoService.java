package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.model.Produto;
import com.ecommerce.projetotestes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void criarProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return this.produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return this.produtoRepository.findById(id);
    }

    public void removerProdutoPorId(Long id) {
        this.produtoRepository.deleteById(id);
    }

    public void atualizarProduto(Produto produtoAntigo) {
        Produto produtoEstoque = produtoRepository.findById(produtoAntigo.getId()
        ).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoEstoque.setNome(produtoAntigo.getNome());
        produtoEstoque.setDescricao(produtoAntigo.getDescricao());
        produtoEstoque.setPreco(produtoAntigo.getPreco());

        produtoRepository.save(produtoEstoque);
    }

}


