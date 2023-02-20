package com.BrandProductApp.BrandProductApp.dto.productDTO;

import com.BrandProductApp.BrandProductApp.validator.UniqueName;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductCreateDTO {

    @NotNull(message = "{backend.constraints.userName.NotNull.message}")
    @Size(min = 5, max = 24,message = "{backend.constraints.userName.Size.message}")
    @UniqueName
    private String name;

    @NotNull(message = "{backend.constraints.price.NotNull.message}")
    @Size(min = 2, max = 32, message = "{backend.constraints.firstName.Size.message}")
    private double price;
}
