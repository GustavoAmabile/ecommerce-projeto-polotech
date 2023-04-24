package com.ecommerce.projetotestes.service;


import com.ecommerce.projetotestes.exception.ProdutoNaoEncontradoException;
import com.ecommerce.projetotestes.model.*;
import com.ecommerce.projetotestes.repository.CarrinhoRepository;
import com.ecommerce.projetotestes.repository.ClienteRepository;
import com.ecommerce.projetotestes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private Venda venda;
    @Autowired
    private Produto produto;
    @Autowired
    private Cliente cliente;



    public Carrinho criarCarrinho(Long idCliente, Long idVenda) {
        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente não encontrado")));
        carrinho.setVenda(venda);
        carrinhoRepository.save(carrinho);
        return carrinho;
    }




}








