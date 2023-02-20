package com.BrandProductApp.BrandProductApp.api.productAPI;

import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductViewDTO;
import com.BrandProductApp.BrandProductApp.service.productService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductAPI {
    private final ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<ProductViewDTO> getProductById(@PathVariable Long id){
        final ProductViewDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<List<ProductViewDTO>> getProduct(){

    }
}
