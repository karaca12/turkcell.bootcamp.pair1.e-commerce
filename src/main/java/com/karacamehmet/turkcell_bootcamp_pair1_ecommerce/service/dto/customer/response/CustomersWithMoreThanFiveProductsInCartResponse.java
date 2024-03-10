package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomersWithMoreThanFiveProductsInCartResponse {
    private int userId;
    private String customerFirstName;
    private String customerLastName;
    private long totalItemsInCart;
}
