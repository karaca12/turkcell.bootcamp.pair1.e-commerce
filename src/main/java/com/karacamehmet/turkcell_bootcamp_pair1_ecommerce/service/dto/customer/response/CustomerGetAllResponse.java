package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerGetAllResponse {
    private Integer id;
    private String lastName;
}
