package com.example.product.Entity;

import jakarta.persistence.*;

// We have removed all Lombok annotations and written the code manually.
@Entity
@Table(name = "neweproduct")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long price;

    // 1. Manually added no-argument constructor (required by JPA and Jackson)
    public Product() {
    }

    // 2. Manually added constructor with all arguments (optional, but good practice)
    public Product(Long id, String name, String description, Long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // 3. Manually added Getters and Setters for all fields
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}