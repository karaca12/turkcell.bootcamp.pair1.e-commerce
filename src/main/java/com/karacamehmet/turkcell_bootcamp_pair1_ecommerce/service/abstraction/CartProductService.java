package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.response.CartProductGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface CartProductService {
    List<CartProductGetAllResponse> getAll();

    Optional<CartProduct> getById(int id);

    void add(CartProductAddRequest cartProductAddRequest);

    void update(CartProductUpdateRequest cartProductUpdateRequest);

    void deleteById(int id);
}
