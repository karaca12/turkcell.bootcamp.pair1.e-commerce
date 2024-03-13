package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.request;

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
public class PaymentAddRequest {
    @Min(1)
    private Integer orderId;
    @Min(1)
    private Integer paymentMethodId;
    @Min(value = 0, message = "Payment amount must be minimum 0")
    private Double amount;
    @NotNull
    private LocalDate date;
    @NotBlank(message = "This field cannot be empty")
    @Size(max = 250)
    private String status;
}
