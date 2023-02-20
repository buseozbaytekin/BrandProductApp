package com.BrandProductApp.BrandProductApp.dto.productDTO;

import com.BrandProductApp.BrandProductApp.model.Product;

public class ProductViewDTO {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;

    public ProductViewDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static ProductViewDTO of(Product product) {
        return new ProductViewDTO((product.getName()),product.getPrice());
    }
}
