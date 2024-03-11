package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.AddressRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.AddressService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.DistrictService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.UserService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserService userService;
    private final DistrictService districtService;

    public AddressServiceImpl(AddressRepository addressRepository,
                              UserService userService,
                              DistrictService districtService) {
        this.addressRepository = addressRepository;
        this.userService = userService;
        this.districtService = districtService;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public void add(AddressAddRequest addressAddRequest) {

        Address address = new Address();
        address.setDetails(addressAddRequest.getDetails());
        findUserAndDistrictByIdAndAddItToAddress(addressAddRequest.getUserId(), addressAddRequest.getDistrictId(), address);

        addressRepository.save(address);
    }

    @Override
    public void update(AddressUpdateRequest addressUpdateRequest) {
        Address address = new Address();
        findUserAndDistrictByIdAndAddItToAddress(addressUpdateRequest.getUserId(), addressUpdateRequest.getDistrictId(), address);
        addressRepository.updateDetailsByIdAndDistrictIdAndUserId(
                addressUpdateRequest.getDetails(), addressUpdateRequest.getUpdatedId(), address.getDistrictId(), address.getUserId());
    }

    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }

    private void findUserAndDistrictByIdAndAddItToAddress(Integer userId, Integer districtId, Address address) {
        User user = userService.getById(userId).orElseThrow(()->new BusinessException("There is an issue finding the user"));
        address.setUserId(user);

        District district = districtService.getById(districtId).orElseThrow(()->new BusinessException("There is an issue finding the district"));
        address.setDistrictId(district);
    }

}
