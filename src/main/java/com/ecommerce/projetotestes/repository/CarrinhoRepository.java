package com.ecommerce.projetotestes.repository;

import com.ecommerce.projetotestes.model.Carrinho;
import com.ecommerce.projetotestes.model.ItemVenda;
import com.ecommerce.projetotestes.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{

    Carrinho findByClienteId(Long idCliente);
}
