package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentGetAllResponse {
    private Integer id;
    private Integer orderId;
    private Integer paymentMethodId;
    private Double amount;
    private LocalDate date;
    private String status;
}
