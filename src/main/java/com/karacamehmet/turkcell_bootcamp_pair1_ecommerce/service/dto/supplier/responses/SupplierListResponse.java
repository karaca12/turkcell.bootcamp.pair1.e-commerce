package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SupplierListResponse {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String taxNo;
    private Float rating;


}
