package com.BrandProductApp.BrandProductApp.api.brandAPI;

import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandCreateDTO;
import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandUpdateDTO;
import com.BrandProductApp.BrandProductApp.dto.brandDTO.BrandViewDTO;
import com.BrandProductApp.BrandProductApp.service.brandService.BrandService;
import com.BrandProductApp.BrandProductApp.util.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
@RequiredArgsConstructor
public class BrandAPI {
    private  final BrandService brandService;

    @GetMapping("{id}")
    public ResponseEntity<BrandViewDTO> getBrandById(@PathVariable Long id){
        final BrandViewDTO brand = brandService.getBrandById(id);
        return ResponseEntity.ok(brand);
    }
    @PostMapping
    public ResponseEntity<?> createBrand(@Valid @RequestBody BrandCreateDTO brandCreateDTO){
        brandService.createBrand(brandCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Brand created successfully!"));
    }

    @PutMapping
    public ResponseEntity<BrandViewDTO> updateBrand(@PathVariable Long id, @RequestBody BrandUpdateDTO brandUpdateDTO){
        final BrandViewDTO brand = brandService.updateBrand(id, brandUpdateDTO);
        return ResponseEntity.ok(brand);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable ("id") Long id){
        brandService.deleteBrand(id);
        return ResponseEntity.ok(new GenericResponse("Deleted!"));
    }

    @GetMapping("{slice}")
    public ResponseEntity<List<BrandViewDTO>> sliceBrand(Pageable pageable){
        final List<BrandViewDTO> brands = brandService.slice(pageable);
        return ResponseEntity.ok(brands);
    }
}
