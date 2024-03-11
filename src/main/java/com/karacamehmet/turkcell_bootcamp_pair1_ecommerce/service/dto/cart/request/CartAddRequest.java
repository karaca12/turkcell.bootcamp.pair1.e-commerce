package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartAddRequest {
    @Min(1)
    private Integer customerId;
    @NotNull
    private LocalDate createdAt;
    @NotNull
    private LocalDate updatedAt;
}
