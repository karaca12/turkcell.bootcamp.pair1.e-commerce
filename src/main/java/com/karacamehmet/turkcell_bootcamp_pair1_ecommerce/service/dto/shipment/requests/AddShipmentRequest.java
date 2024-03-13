package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddShipmentRequest {
    @Min(1)
    private Integer id;
    @Min(1)
    private Integer orderId;
    private LocalDate shippedDate;
    private LocalDate estimatedDeliveryDate;
    @NotBlank(message = "Status of an shipment cannot be empty")
    private String status;
}
