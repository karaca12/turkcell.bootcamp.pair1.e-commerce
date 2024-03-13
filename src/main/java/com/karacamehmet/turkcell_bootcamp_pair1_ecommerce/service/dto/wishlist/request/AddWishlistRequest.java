package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.request;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AddWishlistRequest {
    @Min(1)
    private Integer id;

    @NotNull
    private Customer customerId;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
