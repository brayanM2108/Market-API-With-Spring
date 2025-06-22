package com.brayan.market.persistence;

import com.brayan.market.domain.Product;
import com.brayan.market.domain.repository.ProductRepository;
import com.brayan.market.persistence.crud.ProductoCrudRepository;
import com.brayan.market.persistence.entity.Producto;
import com.brayan.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private final ProductoCrudRepository productoCrudRepository;

    private final ProductMapper productMapper;

    @Autowired
    public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductMapper mapper){
        this.productoCrudRepository = productoCrudRepository;
        this.productMapper = mapper;
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(productMapper::toProducts);
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(productMapper::toProduct);
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }








}
