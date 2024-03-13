package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodGetAllResponse {
    private Integer id;
    private String name;
}
