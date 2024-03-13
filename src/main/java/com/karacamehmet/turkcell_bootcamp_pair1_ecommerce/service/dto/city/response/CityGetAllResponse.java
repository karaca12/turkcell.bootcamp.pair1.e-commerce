package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityGetAllResponse {
    private Integer id;
    private Integer countryId;
    private String name;
}
