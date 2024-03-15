package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.response.CartProductGetAllResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cartproducts")
public class CartProductsController {
    private final CartProductService cartProductService;

    @GetMapping
    List<CartProductGetAllResponse> getAll() {
        return cartProductService.getAll();
    }

    @PostMapping
    void add(@RequestBody @Valid CartProductAddRequest cartProductAddRequest) {
        cartProductService.add(cartProductAddRequest);
    }

    @PutMapping
    void update(@RequestBody @Valid CartProductUpdateRequest cartProductUpdateRequest) {
        cartProductService.update(cartProductUpdateRequest);
    }
}