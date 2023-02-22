package com.BrandProductApp.BrandProductApp.dto.productDTO;

import com.BrandProductApp.BrandProductApp.model.Brand;
import com.BrandProductApp.BrandProductApp.model.Product;

public class ProductViewDTO {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;
    private Brand brand;

    public ProductViewDTO(String name, double price, Brand brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public static ProductViewDTO of(Product product) {
        return new ProductViewDTO((product.getName()),product.getPrice(),product.getBrand());
    }
}
