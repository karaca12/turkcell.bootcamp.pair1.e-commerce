package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerNullOrderResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveProductsInCartResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping()
    List<CustomerGetAllResponse> getAll() {
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

    @PostMapping
    void createCustomer(@RequestBody @Valid CustomerAddRequest customerAddRequest) {
        customerService.add(customerAddRequest);
    }

    @PutMapping
    void updateCustomer(@RequestBody @Valid CustomerUpdateRequest customerUpdateRequest) {
        customerService.update(customerUpdateRequest);
    }

}
