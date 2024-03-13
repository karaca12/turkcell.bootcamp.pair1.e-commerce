package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.request;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersProductAddRequest {
    @Min(1)
    private Integer orderId;
    @Min(1)
    private Integer productId;
    @Min(1)
    private Integer quantity;
    @Min(value = 0, message = "Price of a product must be minimum 0")
    private Double price;
}
