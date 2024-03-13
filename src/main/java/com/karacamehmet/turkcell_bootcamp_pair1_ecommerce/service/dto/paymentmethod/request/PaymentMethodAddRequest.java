package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodAddRequest {
    @Length(min = 2, max = 30)
    private String name;
}
