package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddAddressRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.UpdateAddressRequest;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAll();

    Optional<Address> getById(int id);

    void add(AddAddressRequest addAddressRequest);

    void update(UpdateAddressRequest updateAddressRequest);

    void deleteById(int id);
}
