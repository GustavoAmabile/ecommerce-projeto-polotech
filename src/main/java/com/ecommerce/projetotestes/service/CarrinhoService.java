package com.ecommerce.projetotestes.service;


import com.ecommerce.projetotestes.exception.ProdutoNaoEncontradoException;
import com.ecommerce.projetotestes.model.*;
import com.ecommerce.projetotestes.repository.CarrinhoRepository;
import com.ecommerce.projetotestes.repository.ClienteRepository;
import com.ecommerce.projetotestes.repository.ProdutoRepository;
import com.ecommerce.projetotestes.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Autowired
    private VendaRepository vendaRepository;


    public void criarCarrinho(Long idCliente, Long idVenda) {
        Carrinho carrinho = new Carrinho();
        Optional<Cliente> cliente =
                clienteRepository.findById(idCliente);
        Venda venda = new Venda();
        Optional<Venda> vendaOptional =
                vendaRepository.findById(idVenda);
        carrinho.setCliente(cliente.get());
        carrinho.setVenda(vendaOptional.get());
        carrinhoRepository.save(carrinho);

    }




}








