package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.order;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.address.AddressDto;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dtos.customer.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private CustomerDto customer;
    private AddressDto address;
    private LocalDate orderDate;
    private String status;
    private Double totalPrice;
}
