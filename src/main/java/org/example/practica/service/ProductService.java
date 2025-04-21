package org.example.practica.service;

import org.example.practica.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    void delete(Long id);
    List<Product> findAll();
    Product findById(Long id);
}
