package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.request;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesProductAddRequest {
    @Min(1)
    private Integer categoryId;
    @Min(1)
    private Integer productId;
}
