package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.UserService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.request.UserAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.response.UserAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/address/{userId}")
    UserAddressResponse getUserAddress(@PathVariable int userId) {
        return userService.getUserAddress(userId);
    }

    @GetMapping("/countOfCustomers")
    int countByCustomerNotNull(){
        return userService.countByCustomerNotNull();
    }
    @GetMapping("/countOfSuppliers")
    long count(){
        return userService.countBySupplierNotNull();
    }

    @PostMapping()
    User addUser(@RequestBody @Valid UserAddRequest userAddRequest) {
        return userService.add(userAddRequest);
    }
}
