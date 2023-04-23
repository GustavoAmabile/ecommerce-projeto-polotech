package com.ecommerce.projetotestes.service;

import com.ecommerce.projetotestes.exception.CampoVazioException;
import com.ecommerce.projetotestes.exception.RegistroDuplicadoException;
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
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RegistroDuplicadoException();
        } else if(cliente.getNome().isEmpty() || cliente.getDocumento().isEmpty() || cliente.getEmail().isEmpty()){
            throw new CampoVazioException();
        }
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

    public void atualizarCliente(Cliente clienteDesatualizado) {
        Cliente clienteAtualizado = clienteRepository.findById(clienteDesatualizado.getId()
        ).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteAtualizado.setNome(clienteAtualizado.getNome());
        clienteAtualizado.setDocumento(clienteDesatualizado.getDocumento());
        clienteAtualizado.setEmail(clienteDesatualizado.getEmail());

        clienteRepository.save(clienteAtualizado);
    }


}
