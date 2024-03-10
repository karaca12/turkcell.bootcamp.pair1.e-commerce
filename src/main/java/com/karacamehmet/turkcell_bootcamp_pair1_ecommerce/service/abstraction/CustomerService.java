package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerNullOrderResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveProductsInCartResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAll();

    Optional<Customer> getById(int id);

    void add(Customer customer);

    void update(Customer customer);

    void deleteById(int id);

    List<CustomerNullOrderResponse> findAllByOrdersNull();

    List<CustomersWithMoreThanFiveProductsInCartResponse> getCustomersWithMoreThanFiveProductsInCart();
}
