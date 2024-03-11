package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.AddressRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.DistrictRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.UserRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.AddressService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddAddressRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.UpdateAddressRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final DistrictRepository districtRepository;

    public AddressServiceImpl(AddressRepository addressRepository,
                              UserRepository userRepository,
                              DistrictRepository districtRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.districtRepository = districtRepository;
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
    public void add(AddAddressRequest addAddressRequest) {

        Address address = new Address();
        address.setDetails(addAddressRequest.getDetails());
        findUserAndDistrictByIdAndAddItToAddress(addAddressRequest.getUserId(), addAddressRequest.getDistrictId(), address);

        addressRepository.save(address);
    }

    @Override
    public void update(UpdateAddressRequest updateAddressRequest) {
        Address address = new Address();
        findUserAndDistrictByIdAndAddItToAddress(updateAddressRequest.getUserId(), updateAddressRequest.getDistrictId(), address);
        addressRepository.updateDetailsByIdAndDistrictIdAndUserId(
                updateAddressRequest.getDetails(), updateAddressRequest.getUpdatedId(), address.getDistrictId(), address.getUserId());
    }

    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }

    private void findUserAndDistrictByIdAndAddItToAddress(Integer userId, Integer districtId, Address address) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElse(new User());
        address.setUserId(user);

        Optional<District> optionalDistrict = districtRepository.findById(districtId);
        District district = optionalDistrict.orElse(new District());
        address.setDistrictId(district);
    }

}
