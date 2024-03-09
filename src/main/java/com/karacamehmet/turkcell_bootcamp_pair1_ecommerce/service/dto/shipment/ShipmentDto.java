package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.OrderDto;

import java.time.LocalDate;

public class ShipmentDto {
    private Integer id;
    private OrderDto order;
    private LocalDate shippedDate;
    private LocalDate estimatedDeliveryDate;
    private String status;
}
