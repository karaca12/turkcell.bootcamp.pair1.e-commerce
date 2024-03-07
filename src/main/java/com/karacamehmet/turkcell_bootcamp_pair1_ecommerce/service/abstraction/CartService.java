package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> getAll();

    Optional<Cart> getById(int id);

    void add(Cart cart);

    void update(Cart cart);

    void deleteById(int id);
}
