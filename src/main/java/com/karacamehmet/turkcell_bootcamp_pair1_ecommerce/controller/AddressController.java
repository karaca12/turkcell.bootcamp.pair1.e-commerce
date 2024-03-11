package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.AddressService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.response.AddressGetAllResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping()
    List<AddressGetAllResponse> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    Optional<Address> getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PostMapping
    void add(@RequestBody @Valid AddressAddRequest addressAddRequest) {
        addressService.add(addressAddRequest);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        addressService.deleteById(id);
    }

    @PutMapping
    void update(@RequestBody @Valid AddressUpdateRequest addressUpdateRequest) {
        addressService.update(addressUpdateRequest);
    }
}
