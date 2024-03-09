package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.DistrictDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Integer id;
    private DistrictDto district;
    private String details;

}
