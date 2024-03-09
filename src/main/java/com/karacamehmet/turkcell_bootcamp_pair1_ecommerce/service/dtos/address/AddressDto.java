package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.address;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.district.DistrictDto;
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
