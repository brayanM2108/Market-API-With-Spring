package com.brayan.market.web.controller;

import com.brayan.market.domain.Product;
import com.brayan.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId){
        return  productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId")  int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping
    public  Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id")  int productId){
        return productService.delete(productId);
    }
}
