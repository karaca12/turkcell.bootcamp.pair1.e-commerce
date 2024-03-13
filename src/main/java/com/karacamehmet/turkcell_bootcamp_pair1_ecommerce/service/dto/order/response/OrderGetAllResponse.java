package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderGetAllResponse {
    private Integer id;
    private Integer customerId;
    private Integer addressId;
    private LocalDate orderDate;
    private String status;
    private Double totalPrice;
}
