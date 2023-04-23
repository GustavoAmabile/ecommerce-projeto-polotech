package com.ecommerce.projetotestes.model.dao;

import com.ecommerce.projetotestes.model.Endereco;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface EnderecoDAO extends ListCrudRepository<Endereco, Long> {


}
