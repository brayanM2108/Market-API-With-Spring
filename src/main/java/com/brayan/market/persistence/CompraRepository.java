package com.brayan.market.persistence;

import com.brayan.market.domain.Purchase;
import com.brayan.market.domain.repository.PurchaseRepository;
import com.brayan.market.persistence.crud.CompraCrudRepository;
import com.brayan.market.persistence.entity.Compra;
import com.brayan.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private final CompraCrudRepository compraCrudRepository;

    private final PurchaseMapper purchaseMapper;

    @Autowired
    public CompraRepository(CompraCrudRepository compraCrudRepository, PurchaseMapper purchaseMapper) {
        this.compraCrudRepository = compraCrudRepository;
        this.purchaseMapper = purchaseMapper;
    }


    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchase((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(purchaseMapper::toPurchase);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        if (compra.getIdCompra() == 0){
        compra.setIdCompra(null);
        }
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
