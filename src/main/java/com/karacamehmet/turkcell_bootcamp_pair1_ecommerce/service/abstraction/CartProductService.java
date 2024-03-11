package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.response.CartProductGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface CartProductService {
    List<CartProductGetAllResponse> getAll();

    Optional<CartProduct> getById(int id);

    void add(CartProduct cartProduct);

    void update(CartProduct cartProduct);

    void deleteById(int id);
}
