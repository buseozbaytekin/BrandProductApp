package com.BrandProductApp.BrandProductApp.repository;

import com.BrandProductApp.BrandProductApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Product, Long> {
    boolean existsBrandByName(String name);
}
