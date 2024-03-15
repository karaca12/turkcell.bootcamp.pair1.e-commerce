package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerNullOrderResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveProductsInCartResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.registration.request.CustomerRegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerGetAllResponse> getAll();

    Optional<Customer> getById(int id);

    void add(CustomerAddRequest customerAddRequest);

    Customer add(CustomerRegistrationRequest customerRegistrationRequest);

    void update(CustomerUpdateRequest customerUpdateRequest);

    void deleteById(int id);

    List<CustomerNullOrderResponse> findAllByOrdersNull();

    List<CustomersWithMoreThanFiveProductsInCartResponse> getCustomersWithMoreThanFiveProductsInCart();
}
