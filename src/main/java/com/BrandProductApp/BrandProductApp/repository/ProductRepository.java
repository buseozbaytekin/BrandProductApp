package com.BrandProductApp.BrandProductApp.repository;

import com.BrandProductApp.BrandProductApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsProductByName(String name);
}
