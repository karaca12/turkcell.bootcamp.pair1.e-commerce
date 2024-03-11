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
public class AddressAddRequest {
    @Min(1)
    @NotBlank
    private Integer districtId;
    @Min(1)
    @NotBlank
    private Integer userId;
    @NotBlank(message = "This field cannot be empty")
    @Size(max = 250)
    private String details;
}
