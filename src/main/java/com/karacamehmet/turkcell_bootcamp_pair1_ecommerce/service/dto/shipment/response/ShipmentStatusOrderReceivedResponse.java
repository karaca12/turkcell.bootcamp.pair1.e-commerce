package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentStatusOrderReceivedResponse {

    private int id;
    private int orderId;
    private int customerId;
    private LocalDate shippedDate;
    private LocalDate estimatedDeliveryDate;
    private String status;
}
