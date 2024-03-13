package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {
    private Integer id;
    private String name;
    private List<Integer> categoryIds;
    private double price;
}
