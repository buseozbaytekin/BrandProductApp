package com.BrandProductApp.BrandProductApp.repository;

import com.BrandProductApp.BrandProductApp.model.Brand;
import com.BrandProductApp.BrandProductApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    boolean existsBrandByName(String name);
}
