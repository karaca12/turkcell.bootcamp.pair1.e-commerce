package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictGetAllResponse {
    private Integer id;
    private Integer cityId;
    private String name;
}
