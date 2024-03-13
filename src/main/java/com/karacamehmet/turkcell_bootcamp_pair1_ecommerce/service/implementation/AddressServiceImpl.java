package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.AddressRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.AddressService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.response.AddressGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.AddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressGetAllResponse> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return AddressMapper.INSTANCE.addressGetAllResponseListFromAddressList(addresses);
    }

    @Override
    public Optional<Address> getById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public void add(AddressAddRequest addressAddRequest) {

        Address address = AddressMapper.INSTANCE.addressFromAddRequest(addressAddRequest);

        addressRepository.save(address);
    }

    @Override
    public void update(AddressUpdateRequest addressUpdateRequest) {
        addressRepository.findById(addressUpdateRequest.getUpdatedId()).orElseThrow(() -> new BusinessException("Address with this id doesn't exist"));
        Address address = AddressMapper.INSTANCE.addressFromUpdateRequest(addressUpdateRequest);
        addressRepository.save(address);
    }

    @Override
    public void updateDetail(AddressUpdateRequest addressUpdateRequest) {
        Address address = AddressMapper.INSTANCE.addressFromUpdateRequest(addressUpdateRequest);
        addressRepository.updateDetailsByIdAndDistrictIdAndUserId(
                addressUpdateRequest.getDetails(), addressUpdateRequest.getUpdatedId(), address.getDistrictId(), address.getUserId());
    }


    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }

}
