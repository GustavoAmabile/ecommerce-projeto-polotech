package com.ecommerce.projetotestes.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_item_venda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ItemVenda {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private LocalDateTime dataVenda;

    @Column(nullable = false)
    private Integer quantidade;

}
