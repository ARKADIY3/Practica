package org.example.practica.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "suppliers") // имя таблицы в базе данных
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactInfo;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public Supplier() {
    }

    public Supplier(Long id, String name, String contactInfo, List<Product> products) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}