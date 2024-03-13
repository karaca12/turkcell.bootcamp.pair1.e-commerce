package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryGetAllResponse {
    private Integer id;
    private String name;
}
