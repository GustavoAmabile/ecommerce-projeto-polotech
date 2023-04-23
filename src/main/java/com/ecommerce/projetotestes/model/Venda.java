package com.ecommerce.projetotestes.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_venda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Venda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ItemVenda> quantidadeItens = new ArrayList<>();

    public List<ItemVenda> getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(List<ItemVenda> quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }


}
