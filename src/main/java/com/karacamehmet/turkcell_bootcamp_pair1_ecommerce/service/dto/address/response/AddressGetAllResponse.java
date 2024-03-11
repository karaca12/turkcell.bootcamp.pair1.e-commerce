package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressGetAllResponse {
    private Integer id;
    private Integer districtId;
    private Integer userId;
    private String  details;
}
