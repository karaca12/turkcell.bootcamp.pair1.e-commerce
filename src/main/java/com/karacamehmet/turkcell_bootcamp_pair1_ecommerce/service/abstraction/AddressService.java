package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.response.AddressGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressGetAllResponse> getAll();

    Optional<Address> getById(int id);

    void add(AddressAddRequest addressAddRequest);

    void update(AddressUpdateRequest addressUpdateRequest);
    void updateDetail(AddressUpdateRequest addressUpdateRequest);

    void deleteById(int id);
}
