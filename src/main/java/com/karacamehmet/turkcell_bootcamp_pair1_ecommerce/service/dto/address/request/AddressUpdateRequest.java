package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressUpdateRequest {
    @Setter(AccessLevel.NONE)
    @Min(1)
    private Integer updatedId;
    @Setter(AccessLevel.NONE)
    @Min(1)
    private Integer districtId;
    @Setter(AccessLevel.NONE)
    @Min(1)
    private Integer userId;
    @NotBlank(message = "Details of an address cannot be empty")
    @Size(max = 250)
    @NonNull
    private String details;
}
