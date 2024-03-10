package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CustomerRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerNullOrderResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveInCart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerNullOrderResponse> findAllByOrdersNull() {
        List<Customer> customers = customerRepository.findAllByOrdersNull();
        List<CustomerNullOrderResponse> response = new ArrayList<>();
        for (Customer customer :
                customers) {
            CustomerNullOrderResponse dto = new
                    CustomerNullOrderResponse(customer.getId(), customer.getUsers().getName(), customer.getLastName());
            response.add(dto);
        }
        return response;
    }

    @Override
    public List<CustomersWithMoreThanFiveInCart> getCustomersWithMoreThanFiveInCart() {
        return customerRepository.getCustomersWithMoreThanFiveInCart();
    }
}
