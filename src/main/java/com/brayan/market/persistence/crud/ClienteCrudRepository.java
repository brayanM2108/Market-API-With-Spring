package com.brayan.market.persistence.crud;

import com.brayan.market.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {
    List<Cliente> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);
}
