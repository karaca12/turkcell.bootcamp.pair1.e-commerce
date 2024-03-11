package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Cart;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.CartAddRequest;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> getAll();

    Optional<Cart> getById(int id);

    void add(CartAddRequest cartAddRequest);

    void update(Cart cart);

    void deleteById(int id);
}
