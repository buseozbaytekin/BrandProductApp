package com.BrandProductApp.BrandProductApp.service.productService;

import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductCreateDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductUpdateDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductViewDTO;
import com.BrandProductApp.BrandProductApp.exception.NotFoundException;
import com.BrandProductApp.BrandProductApp.model.Product;
import com.BrandProductApp.BrandProductApp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;


    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public ProductViewDTO getProductById(Long id) {
        final Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found exception"));
        return ProductViewDTO.of(product);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<ProductViewDTO> getProduct() {
        return productRepository.findAll().stream().map(ProductViewDTO::of).collect(Collectors.toList());
    }

    @Override
    public ProductViewDTO createProduct(ProductCreateDTO productCreateDTO) {
        final Product product = productRepository.save(
                new Product(productCreateDTO.getName(),productCreateDTO.getPrice())
        );
        return ProductViewDTO.of(product);
    }

    @Override
    @Transactional
    public ProductViewDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO) {
        final Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        product.setName(productUpdateDTO.getName());
        product.setPrice(product.getPrice());
        return null;
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        final Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        productRepository.deleteById(product.getId());
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<ProductViewDTO> slice(Pageable pageable) {
        return productRepository.findAll(pageable).stream().map(ProductViewDTO::of).collect(Collectors.toList());
    }
}
