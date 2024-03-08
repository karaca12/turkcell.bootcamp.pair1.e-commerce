package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Cart;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/carts")
public class CartController {
    private final CartService cartService;

    @GetMapping
    List<Cart> getAll() {
        return cartService.getAll();
    }
}