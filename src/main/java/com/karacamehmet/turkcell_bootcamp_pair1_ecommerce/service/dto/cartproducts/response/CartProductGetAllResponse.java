package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartProductGetAllResponse {
    private Integer id;
    private Integer cartId;
    private Integer productId;
    private Integer quantity;
    private LocalDate addedAt;
}
