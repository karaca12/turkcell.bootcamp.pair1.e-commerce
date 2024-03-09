package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;

import java.util.List;
import java.util.Optional;

public interface CartProductService {
    List<CartProduct> getAll();

    Optional<CartProduct> getById(int id);

    void add(CartProduct cartProduct);

    void update(CartProduct cartProduct);

    void deleteById(int id);
}
