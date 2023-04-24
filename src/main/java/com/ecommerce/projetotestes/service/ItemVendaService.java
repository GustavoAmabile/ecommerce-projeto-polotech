package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.model.Cliente;
import com.ecommerce.projetotestes.model.ItemVenda;
import com.ecommerce.projetotestes.model.Produto;
import com.ecommerce.projetotestes.model.Venda;
import com.ecommerce.projetotestes.repository.ClienteRepository;
import com.ecommerce.projetotestes.repository.ItemVendaRepository;
import com.ecommerce.projetotestes.repository.ProdutoRepository;
import com.ecommerce.projetotestes.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void criarItemVenda(Long idProduto, Long idVenda, ItemVenda itemVenda) {

        ItemVenda item = new ItemVenda();

        Venda venda = new Venda();

        Optional<Produto> produto =
                produtoRepository.findById(idProduto);

        Optional<Venda> vendaOptional =
                vendaRepository.findById(idVenda);

        item.setProduto(produto.get());
        item.setVenda(vendaOptional.get());
        item.setQuantidade(itemVenda.getQuantidade());

        itemVendaRepository.save(item);
    }
    public void criarVenda(Venda venda, Long idCliente) {
        Optional<Cliente> cliente =
                clienteRepository.findById(idCliente);
        venda.setCliente(cliente.get());
        vendaRepository.save(venda);

    }
}
