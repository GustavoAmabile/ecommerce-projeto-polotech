package com.ecommerce.projetotestes.model.dao;

import com.ecommerce.projetotestes.model.Produto;
import org.springframework.data.repository.ListCrudRepository;

public interface ProdutoDAO extends ListCrudRepository<Produto, Long> {
}
