package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.model.Venda;
import com.ecommerce.projetotestes.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public VendaRepository getVendaRepository() {
        return vendaRepository;
    }

    public void setVendaRepository(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }
    public void criarVenda(Venda venda) {
        vendaRepository.save(venda);
    }
}
