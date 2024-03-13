package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSupplierRequest {
    @Min(1)
    private int userId;
    @NotBlank(message = "Tax no cannot be empty")
    private String taxNo;
    @Min(value = 0,message = "Rating cannot be lower than 0")
    private Float rating;
}
