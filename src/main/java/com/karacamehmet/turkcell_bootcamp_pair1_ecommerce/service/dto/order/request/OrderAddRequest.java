package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderAddRequest {
    @Min(1)
    private Integer customerId;
    @Min(1)
    private Integer addressId;
    @NotNull
    private LocalDate orderDate;
    @NotBlank(message = "This field cannot be empty")
    @Size(max = 250)
    private String status;
    @Min(value = 0, message = "Total price must be minimum 0")
    private Double totalPrice;
}

