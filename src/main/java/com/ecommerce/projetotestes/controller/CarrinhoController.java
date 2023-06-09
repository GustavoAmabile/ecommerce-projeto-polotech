package com.ecommerce.projetotestes.controller;

import com.ecommerce.projetotestes.model.Carrinho;
import com.ecommerce.projetotestes.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {


    @Autowired
    private CarrinhoService carrinhoService;


    @PostMapping("/criar/{idCliente}/{idVenda}")
    public void criarCarrinho(@PathVariable Long idCliente, @PathVariable Long idVenda){
         carrinhoService.criarCarrinho(idCliente, idVenda);
    }


}
