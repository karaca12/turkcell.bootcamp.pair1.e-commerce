package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductHowManySoldResponse {
    private String name;
    private Long total_sales;
}
