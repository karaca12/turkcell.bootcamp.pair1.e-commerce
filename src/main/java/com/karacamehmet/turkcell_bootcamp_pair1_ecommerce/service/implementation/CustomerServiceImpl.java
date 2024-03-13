package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CustomerRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerNullOrderResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveProductsInCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;


    @Override
    public List<CustomerGetAllResponse> getAll() {
        return customerRepository.findAll().stream()
                .map(customer -> {
                    return CustomerGetAllResponse.builder()
                            .id(customer.getId())
                            .lastName(customer.getLastName())
                            .build();
                }).toList();
    }

    @Override
    public Optional<Customer> getById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void add(CustomerAddRequest customerAddRequest) { //YAPAMADIM !!!
        Customer customer = new Customer();
        customer.setLastName(customerAddRequest.getLastName());

        customerRepository.save(customer);
    }

    @Override
    public void update(CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = getById(customerUpdateRequest.getUpdatedId())
                .orElseThrow(() -> new BusinessException("Customer not found"));
        customer.setLastName(customerUpdateRequest.getLastName());

        customerRepository.save(customer);
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
    public List<CustomersWithMoreThanFiveProductsInCartResponse> getCustomersWithMoreThanFiveProductsInCart() {
        return customerRepository.getCustomersWithMoreThanFiveProductsInCart();
    }
}
