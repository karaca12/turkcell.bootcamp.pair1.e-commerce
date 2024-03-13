package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.request;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AddWishlistRequest {
    @NotNull
    private int customerId;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
