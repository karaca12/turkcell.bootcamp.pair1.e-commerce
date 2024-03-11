package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.response.CartGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.request.CartAddRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/carts")
public class CartController {
    private final CartService cartService;

    @GetMapping
    List<CartGetAllResponse> getAll() {
        return cartService.getAll();
    }

    @PostMapping
    void add(@RequestBody @Valid CartAddRequest cartAddRequest) {
        cartService.add(cartAddRequest);
    }
}