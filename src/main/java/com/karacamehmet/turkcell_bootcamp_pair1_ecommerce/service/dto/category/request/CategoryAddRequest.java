package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryAddRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
