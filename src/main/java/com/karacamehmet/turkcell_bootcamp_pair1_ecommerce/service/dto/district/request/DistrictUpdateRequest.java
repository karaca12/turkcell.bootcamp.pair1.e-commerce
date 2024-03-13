package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictUpdateRequest {
    @Min(1)
    @NotNull(message = "This field cannot be empty")
    private Integer updatedId;
    @Min(1)
    @NotNull(message = "This field cannot be empty")
    private Integer cityId;
    @NotBlank(message = "This field cannot be empty")
    @Size(max = 250, message = "This field cannot be greater than 250 char")
    private String name;
}
