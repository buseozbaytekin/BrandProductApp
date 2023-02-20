package com.BrandProductApp.BrandProductApp.dto.productDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductUpdateDTO {
    @NotNull(message = "{backend.constraints.name.NotNull.message}")
    @Size (message = "{backend.constraints.name.Size.message}")
    private String name;

    @NotNull (message = "{backend.constraints.price.NotNull.message}")
    @Size(min = 5, max = 24,message = "{backend.constraints.userName.Size.message}")
    private double price;
}
