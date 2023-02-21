package com.BrandProductApp.BrandProductApp.service.brandService;

import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandCreateDTO;
import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandUpdateDTO;
import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandViewDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductCreateDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductUpdateDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {
    BrandViewDTO getBrandById(Long id);
    List<BrandViewDTO> getBrand();
    BrandViewDTO createBrand(BrandCreateDTO brandCreateDTO);
    BrandViewDTO updateBrand(Long id, BrandUpdateDTO brandUpdateDTO);
    void deleteBrand(Long id);
    List<BrandViewDTO> slice(Pageable pageable);
}
