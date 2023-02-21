package com.BrandProductApp.BrandProductApp.dto.productDTO;

import com.BrandProductApp.BrandProductApp.model.Brand;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductUpdateDTO {
    @NotNull(message = "{backend.constraints.productName.NotNull.message}")
    @Size (message = "{backend.constraints.productName.Size.message}")
    private String name;

    @NotNull (message = "{backend.constraints.price.NotNull.message}")
    private double price;

    @NotNull(message = "backend.constraints.brandName.NotNull.message")
    @Size(min = 2, max = 29 , message = "{backend.constraints.brandName.Size.message}")
    private Brand brand;
}
