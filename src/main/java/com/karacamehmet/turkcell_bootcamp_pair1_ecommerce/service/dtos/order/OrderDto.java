package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.order;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.address.AddressDto;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.customer.CustomerDto;

import java.time.LocalDate;

public class OrderDto {
    private Integer id;
    private CustomerDto customer;
    private AddressDto address;
    private LocalDate orderDate;
    private String status;
    private Double totalPrice;
}
