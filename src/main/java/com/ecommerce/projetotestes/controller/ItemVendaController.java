package com.ecommerce.projetotestes.controller;

import com.ecommerce.projetotestes.model.ItemVenda;
import com.ecommerce.projetotestes.model.Venda;
import com.ecommerce.projetotestes.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itemvenda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping("/criar/{idProduto}/{idVenda}")
    public void inserirItemVenda(@RequestBody ItemVenda itemVenda, @PathVariable Long idProduto, @PathVariable Long idVenda){
        itemVendaService.criarItemVenda(1L, 1L, itemVenda);
    }

    @PostMapping("/criarvenda/{idCliente}")
    public void inserirVenda(@RequestBody Venda venda, @PathVariable Long idCliente){

        itemVendaService.criarVenda(venda, idCliente);
    }
}
