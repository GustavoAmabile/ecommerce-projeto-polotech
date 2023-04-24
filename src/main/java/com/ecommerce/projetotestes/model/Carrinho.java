package com.ecommerce.projetotestes.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "tb_carrinho")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Carrinho {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_venda", referencedColumnName = "id")
    private Venda venda;


}

