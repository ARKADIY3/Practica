package org.example.practica.service;

import org.example.practica.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    void delete(Long id);
    List<Customer> findAll();
    Customer findById(Long id);
}
