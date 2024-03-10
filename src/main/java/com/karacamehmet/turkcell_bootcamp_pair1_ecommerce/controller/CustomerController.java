package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerNullOrderResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveProductsInCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping()
    List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/withNoOrders")
    List<CustomerNullOrderResponse> findAllByOrdersNull() {
        return customerService.findAllByOrdersNull();
    }

    @GetMapping("/moreThanFiveProductsInCart")
    List<CustomersWithMoreThanFiveProductsInCartResponse> getCustomersWithMoreThanFiveProductsInCart() {
        return customerService.getCustomersWithMoreThanFiveProductsInCart();
    }
}
