package com.ecommerce.projetotestes.controller;

import com.ecommerce.projetotestes.dto.ClienteDTO;
import com.ecommerce.projetotestes.model.Cliente;
import com.ecommerce.projetotestes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public List<Cliente> listarClientes(){
        return clienteService.listarTodos();
    }
    @GetMapping("/buscar/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id).get();
    }

    @PostMapping("/criar")
    public void inserirCliente(@RequestBody Cliente cliente){
        clienteService.criarCliente(cliente);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cliente){
        clienteService.atualizarCliente(cliente);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.removerClientePorId(id);
    }





}
