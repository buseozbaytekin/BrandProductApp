package com.BrandProductApp.BrandProductApp.dto.brandDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BrandUpdateDTO {
    @NotNull(message = "{backend.constraints.brandName.NotNull.message}")
    @Size(message = "{backend.constraints.brandName.Size.message}")
    private String name;
}
