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
    private Long id;

    @Column(name = "name", nullable = false,length = 50,unique = true)
    private String name;

    @Column(name = "price", nullable = false,length = 50,unique = true)
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Product(String name, double price, Brand brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }
}
