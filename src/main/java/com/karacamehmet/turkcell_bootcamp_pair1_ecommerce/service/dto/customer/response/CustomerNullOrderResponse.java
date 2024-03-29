package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerNullOrderResponse {
    private int id;
    private String name;
    private String lastName;
}
