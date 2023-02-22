package com.BrandProductApp.BrandProductApp.dto.brandDTO;

import com.BrandProductApp.BrandProductApp.model.Brand;
import lombok.Getter;

import java.io.Serializable;
@Getter
public class BrandViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;


    public BrandViewDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public static BrandViewDTO of(Brand brand) {
        return new BrandViewDTO(brand.getName(), brand.getId());
    }
}
