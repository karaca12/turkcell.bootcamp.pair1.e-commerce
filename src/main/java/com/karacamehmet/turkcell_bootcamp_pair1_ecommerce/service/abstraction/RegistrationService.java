package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.registration.request.CustomerRegistrationRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.registration.request.SupplierRegistrationRequest;

public interface RegistrationService {
    Customer registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
    Supplier registerSupplier(SupplierRegistrationRequest supplierRegistrationRequest);
}
