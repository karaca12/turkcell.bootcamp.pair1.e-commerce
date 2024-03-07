package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.AddressService;
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
    List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    Optional<Address> getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PostMapping
    void add(@RequestBody Address address) {
        addressService.add(address);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        addressService.deleteById(id);
    }
}
