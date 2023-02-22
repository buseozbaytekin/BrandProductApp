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
import java.util.stream.Collectors;

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
        return brandRepository.findAll().stream().map(BrandViewDTO::of).collect(Collectors.toList());
    }

    @Override
    public BrandViewDTO createBrand(BrandCreateDTO brandCreateDTO) {
        final Brand brand = brandRepository.save(
                new Brand(brandCreateDTO.getId(),brandCreateDTO.getName())
        );
        return BrandViewDTO.of(brand);
    }

    @Override
    @Transactional
    public BrandViewDTO updateBrand(Long id, BrandUpdateDTO brandUpdateDTO) {
        final Brand brand = brandRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found exception"));
        brand.setName(brandUpdateDTO.getName());
        final Brand updatedBrand = brandRepository.save(brand);
        return BrandViewDTO.of(updatedBrand);
    }

    @Override
    @Transactional
    public void deleteBrand(Long id) {
        final Brand brand = brandRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found exception"));
        brandRepository.deleteById(brand.getId());
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<BrandViewDTO> slice(Pageable pageable) {
        return brandRepository.findAll().stream().map(BrandViewDTO::of).collect(Collectors.toList());
    }
}
