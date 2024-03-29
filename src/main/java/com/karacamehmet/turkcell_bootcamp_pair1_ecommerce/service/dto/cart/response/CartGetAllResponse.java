package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartGetAllResponse {
    private Integer id;
    private Integer customerId;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
