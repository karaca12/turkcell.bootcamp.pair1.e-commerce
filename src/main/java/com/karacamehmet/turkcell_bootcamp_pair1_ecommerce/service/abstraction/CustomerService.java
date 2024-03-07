package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
}
