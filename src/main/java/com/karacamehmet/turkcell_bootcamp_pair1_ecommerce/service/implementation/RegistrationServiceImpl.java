package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CustomerRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.SupplierRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.UserRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.RegistrationService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.registration.request.CustomerRegistrationRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.registration.request.SupplierRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final SupplierRepository supplierRepository;

    public RegistrationServiceImpl(UserRepository userRepository,
                                   CustomerRepository customerRepository,
                                   SupplierRepository supplierRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Customer registerCustomer(CustomerRegistrationRequest request) {
        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPasswordHash(request.getPassword());
        newUser.setPhoneNumber(request.getPhoneNumber());
        userRepository.save(newUser);

        Customer newCustomer = new Customer();
        newCustomer.setUsers(newUser);
        newCustomer.setLastName(request.getLastName());
        return customerRepository.save(newCustomer);
    }

    @Override
    public Supplier registerSupplier(SupplierRegistrationRequest request) {
        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPasswordHash(request.getPassword());
        newUser.setPhoneNumber(request.getPhoneNumber());
        userRepository.save(newUser);

        Supplier newSupplier = new Supplier();
        newSupplier.setUsers(newUser);
        return supplierRepository.save(newSupplier);
    }
}