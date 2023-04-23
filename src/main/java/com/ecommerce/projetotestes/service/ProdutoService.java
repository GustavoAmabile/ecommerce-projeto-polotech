package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.exception.CampoVazioException;
import com.ecommerce.projetotestes.exception.RegistroDuplicadoException;
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
        if (produtoRepository.findByNome(produto.getNome()).isPresent()) {
            throw new RegistroDuplicadoException();
        } else if(produto.getNome().isEmpty() || produto.getDescricao().isEmpty() || produto.getPreco().equals(null)) {
            throw new CampoVazioException();
        } else {
            produtoRepository.save(produto);
        }
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

    public void atualizarProduto(Produto produtoDesatualizado) {
        Produto produtoAtualizado = produtoRepository.findById(produtoDesatualizado.getId()
        ).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoAtualizado.setNome(produtoDesatualizado.getNome());
        produtoAtualizado.setDescricao(produtoDesatualizado.getDescricao());
        produtoAtualizado.setPreco(produtoDesatualizado.getPreco());

        produtoRepository.save(produtoAtualizado);
    }

}


