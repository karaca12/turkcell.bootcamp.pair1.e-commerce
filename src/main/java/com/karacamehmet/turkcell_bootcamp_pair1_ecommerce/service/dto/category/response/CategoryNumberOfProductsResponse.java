package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryNumberOfProductsResponse {
    private String categoryName;
    private Long numberOfProducts;
}
