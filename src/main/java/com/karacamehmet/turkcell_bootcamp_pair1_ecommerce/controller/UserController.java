package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.UserService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.response.UserAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @GetMapping
    List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/address/{id}")
    UserAddressResponse getUserAddress(@PathVariable int id) {
        return userService.getUserAddress(id);
    }

    @GetMapping("/countOfCustomers")
    int countByCustomerNotNull(){
        return userService.countByCustomerNotNull();
    }
    @GetMapping("/countOfSuppliers")
    long count(){
        return userService.countBySupplierNotNull();
    }

}
