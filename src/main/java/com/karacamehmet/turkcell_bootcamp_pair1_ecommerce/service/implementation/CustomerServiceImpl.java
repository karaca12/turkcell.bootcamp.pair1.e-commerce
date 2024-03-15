package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CustomerRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.RegistrationService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerNullOrderResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveProductsInCartResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.registration.request.CustomerRegistrationRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private RegistrationService registrationService;

    @Override
    public List<CustomerGetAllResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerMapper.INSTANCE.customerGetAllResponseListFromCustomerList(customers);
    }

    @Override
    public Optional<Customer> getById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void add(CustomerAddRequest customerAddRequest) {
        Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(customerAddRequest);
        customerRepository.save(customer);
    }

    @Override
    public Customer add(CustomerRegistrationRequest customerRegistrationRequest) {
        return registrationService.registerCustomer(customerRegistrationRequest);
    }

    @Override
    public void update(CustomerUpdateRequest customerUpdateRequest) {
        getById(customerUpdateRequest.getUpdatedId())
                .orElseThrow(() -> new BusinessException("Customer not found"));

        Customer customer = CustomerMapper.INSTANCE.customerFromUpdateRequest(customerUpdateRequest);
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
