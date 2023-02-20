package com.BrandProductApp.BrandProductApp.service.productService;

import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductCreateDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductUpdateDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductViewDTO getProductById(Long id);
    List<ProductViewDTO> getProduct();
    ProductViewDTO createProduct(ProductCreateDTO productCreateDTO);
    ProductViewDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO);
    void deleteProduct(Long id);
    List<ProductViewDTO> slice(Pageable pageable);

}
