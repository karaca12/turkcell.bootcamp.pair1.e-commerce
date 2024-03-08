package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.shipment;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.order.OrderDto;

import java.time.LocalDate;

public class ShipmentDto {
    private Integer id;
    private OrderDto order;
    private LocalDate shippedDate;
    private LocalDate estimatedDeliveryDate;
    private String status;
}
