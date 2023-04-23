package com.ecommerce.projetotestes.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_venda", nullable = false)
    private Venda venda;

}
