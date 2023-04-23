package com.ecommerce.projetotestes.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_venda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Component
public class Venda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    private LocalDate dataVenda;
    private BigDecimal valorTotal;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_item_venda", nullable = false)
    private ItemVenda itemVenda;

}
