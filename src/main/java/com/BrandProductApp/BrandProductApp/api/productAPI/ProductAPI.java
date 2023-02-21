package com.BrandProductApp.BrandProductApp.api.productAPI;

import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductCreateDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductUpdateDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductViewDTO;
import com.BrandProductApp.BrandProductApp.service.productService.ProductService;
import com.BrandProductApp.BrandProductApp.util.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<ProductViewDTO>> getProducts(){
        final List<ProductViewDTO> products = productService.getProduct();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<?> createProduct (@Valid @RequestBody ProductCreateDTO productCreateDTO){
        productService.createProduct(productCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User created!"));
    }

    @PutMapping
    public ResponseEntity<ProductViewDTO> updateProduct(@PathVariable("id") Long id, @RequestBody ProductUpdateDTO productUpdateDTO){
        final ProductViewDTO product = productService.updateProduct(id, productUpdateDTO);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable ("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(new GenericResponse("User deleted!"));
    }

    @GetMapping("slice")
    public ResponseEntity<List<ProductViewDTO>> slice(Pageable pageable){
        final List<ProductViewDTO> products = productService.slice(pageable);
        return ResponseEntity.ok(products);
    }

}
