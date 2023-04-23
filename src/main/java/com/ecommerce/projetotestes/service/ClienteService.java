package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.model.Cliente;
import com.ecommerce.projetotestes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void criarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return this.clienteRepository.findById(id);
    }

    public void removerClientePorId(Long id) {
        this.clienteRepository.deleteById(id);
    }



}
