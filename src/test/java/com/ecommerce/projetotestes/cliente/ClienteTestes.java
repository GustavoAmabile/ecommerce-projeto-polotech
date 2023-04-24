package com.ecommerce.projetotestes.cliente;


import com.ecommerce.projetotestes.model.Carrinho;
import com.ecommerce.projetotestes.model.Produto;
import com.ecommerce.projetotestes.repository.CarrinhoRepository;
import com.ecommerce.projetotestes.service.CarrinhoService;
import com.ecommerce.projetotestes.service.ClienteService;
import com.ecommerce.projetotestes.service.ItemVendaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClienteTestes {

    @Autowired
    private Carrinho carrinho;
    @Autowired
    private Produto produto;

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ItemVendaService itemVendaService;

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Test
    public void criarCarrinhoTeste() {
        carrinhoService.criarCarrinho(1L, 1L);
        assertEquals(1, carrinhoRepository.count());
    }



}
