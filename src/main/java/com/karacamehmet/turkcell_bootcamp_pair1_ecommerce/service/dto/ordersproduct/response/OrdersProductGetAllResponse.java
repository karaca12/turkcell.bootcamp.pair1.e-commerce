package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersProductGetAllResponse {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double price;
}
