package com.BrandProductApp.BrandProductApp.dto.brandDTO;

import com.BrandProductApp.BrandProductApp.validator.UniqueName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BrandCreateDTO {
    @NotNull(message = "{backend.constraints.brandID.NotNull.message}")
    private Long id;

    @NotNull(message = "{backend.constraints.brandName.NotNull.message}")
    @Size(min = 5, max = 24,message = "{backend.constraints.brandName.Size.message}")
    @UniqueName(message = "{backend.constraints.UniqueBrandName.message}")
    private String name;


}
