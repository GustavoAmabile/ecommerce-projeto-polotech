package com.ecommerce.projetotestes.dto;
import com.ecommerce.projetotestes.model.Cliente;
public class ClienteDTO {

    private String nome;
    private String documento;
    private String email;

    public Cliente toCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome(this.nome);
        cliente.setDocumento(this.documento);
        cliente.setEmail(this.email);
        return cliente;
    }

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.documento = cliente.getDocumento();
        this.email = cliente.getEmail();
    }

}
