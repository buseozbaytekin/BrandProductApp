package com.BrandProductApp.BrandProductApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false,length = 50,unique = true)
    private String name;

    @Column(name = "price", nullable = false,length = 50,unique = true)
    private double price;

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
