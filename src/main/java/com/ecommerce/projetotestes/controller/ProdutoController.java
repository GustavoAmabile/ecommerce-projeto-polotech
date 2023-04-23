package com.ecommerce.projetotestes.controller;


import com.ecommerce.projetotestes.model.Produto;
import com.ecommerce.projetotestes.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public List<Produto> listarProdutos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id){
        return produtoService.buscarProdutoPorId(id).get();
    }

    @PostMapping("/criar")
    public void inserirProduto(@RequestBody Produto produto){
        produtoService.criarProduto(produto);
    }

    @PutMapping("/atualizar")
    public void atualizarProduto(@RequestBody Produto produto){
        produtoService.atualizarProduto(produto);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.removerProdutoPorId(id);
    }

}
