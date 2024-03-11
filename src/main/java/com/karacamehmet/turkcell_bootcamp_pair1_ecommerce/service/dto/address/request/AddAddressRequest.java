package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {
    @Min(1)
    private Integer districtId;
    @Min(1)
    private Integer userId;
    @NotBlank(message = "Details of an address cannot be empty")
    @Size(max = 250)
    private String details;
}
