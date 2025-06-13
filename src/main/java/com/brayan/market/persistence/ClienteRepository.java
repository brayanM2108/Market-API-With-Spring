package com.brayan.market.persistence;

import com.brayan.market.persistence.crud.ClienteCrudRepository;
import com.brayan.market.persistence.entity.Cliente;

import java.util.List;

public class ClienteRepository {
    private ClienteCrudRepository clienteCrudRepository;

    public List<Cliente> getAll() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }


}
