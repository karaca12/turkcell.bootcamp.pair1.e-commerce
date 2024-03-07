package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CustomerRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
