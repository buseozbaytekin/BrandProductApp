package com.BrandProductApp.BrandProductApp.validator;

import com.BrandProductApp.BrandProductApp.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueNameValidator implements ConstraintValidator<UniqueName,String> {
    private final ProductRepository productRepository;


    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !productRepository.existsProductByName(name);
    }
}
