package com.brayan.market.persistence.crud;

import com.brayan.market.persistence.entity.Cliente;
import com.brayan.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {
    List<Cliente> findByidOrderByNombreAsc(int idCategoria);

}
