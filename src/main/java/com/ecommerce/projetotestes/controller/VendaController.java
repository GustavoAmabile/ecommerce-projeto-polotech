package com.ecommerce.projetotestes.controller;

import com.ecommerce.projetotestes.model.ItemVenda;
import com.ecommerce.projetotestes.model.Venda;
import com.ecommerce.projetotestes.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/criar")
    public void registrarVenda(@RequestBody Venda venda) {
        vendaService.criarVenda(venda.getId(), venda.getItensVenda());
    }



}