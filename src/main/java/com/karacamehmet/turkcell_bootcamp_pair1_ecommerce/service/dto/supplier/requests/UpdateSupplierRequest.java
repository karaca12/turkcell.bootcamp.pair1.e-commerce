package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSupplierRequest {
    private int userId;
    private String taxNo;
    private Float rating;
}
