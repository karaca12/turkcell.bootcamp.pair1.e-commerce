package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.requests;

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
    private Integer id;
    private Integer orderId;
    private LocalDate shippedDate;
    private LocalDate estimatedDeliveryDate;
    private String status;
}
