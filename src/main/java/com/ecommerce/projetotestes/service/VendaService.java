package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.exception.ClienteNaoEncontradoException;
import com.ecommerce.projetotestes.model.Cliente;
import com.ecommerce.projetotestes.model.ItemVenda;
import com.ecommerce.projetotestes.model.Venda;
import com.ecommerce.projetotestes.repository.ClienteRepository;
import com.ecommerce.projetotestes.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Venda criarVenda(Long idCliente, List<ItemVenda> itensVenda) {
        // Verifica se o cliente existe
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException();
        }

        // Cria a venda e adiciona o cliente
        Venda venda = new Venda();
        venda.setCliente(cliente);

        // Adiciona a lista de itens da venda
        venda.setItensVenda(itensVenda);

        // Calcula o valor total da venda
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ItemVenda item : itensVenda) {
            valorTotal = valorTotal.add(item.getVenda().getValorTotal());
        }
        venda.setValorTotal(valorTotal);

        // Salva as alterações no banco de dados
        vendaRepository.save(venda);

        return venda;
    }


}
