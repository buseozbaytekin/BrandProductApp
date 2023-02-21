package com.BrandProductApp.BrandProductApp.service.brandService;

import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandCreateDTO;
import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandUpdateDTO;
import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandViewDTO;
import com.BrandProductApp.BrandProductApp.dto.productDTO.ProductViewDTO;
import com.BrandProductApp.BrandProductApp.exception.NotFoundException;
import com.BrandProductApp.BrandProductApp.model.Brand;
import com.BrandProductApp.BrandProductApp.model.Product;
import com.BrandProductApp.BrandProductApp.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImp implements BrandService{

    private final BrandRepository brandRepository;

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public BrandViewDTO getBrandById(Long id) {
        final Brand brand = brandRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found exception"));
        return BrandViewDTO.of(brand);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<BrandViewDTO> getBrand() {
        return null;
    }

    @Override
    public BrandViewDTO createBrand(BrandCreateDTO brandCreateDTO) {
        return null;
    }

    @Override
    @Transactional
    public BrandViewDTO updateBrand(Long id, BrandUpdateDTO brandUpdateDTO) {
        return null;
    }

    @Override
    @Transactional
    public void deleteBrand(Long id) {

    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<BrandViewDTO> slice(Pageable pageable) {
        return null;
    }
}
