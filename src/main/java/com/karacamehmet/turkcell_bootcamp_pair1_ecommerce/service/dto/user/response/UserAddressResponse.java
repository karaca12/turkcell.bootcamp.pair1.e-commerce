package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressResponse {
    private String userName;
    private String addressDetail;
    private String districtName;
    private String cityName;
    private String countryName;
}
