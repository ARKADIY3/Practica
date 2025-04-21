package org.example.practica.impl;

import org.example.practica.model.Product;
import org.example.practica.repo.ProductRepository;
import org.example.practica.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplProduct implements ProductService {

    private final ProductRepository productRepository;

    public ImplProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
