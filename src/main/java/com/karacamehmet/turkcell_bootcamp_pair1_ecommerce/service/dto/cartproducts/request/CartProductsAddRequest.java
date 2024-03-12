package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartProductsAddRequest {
    @Min(1)
    private Integer cartId;
    @Min(1)
    private Integer productId;
    @Min(1)
    private Integer quantity;
    @NotNull
    private LocalDate addedAt;
}
