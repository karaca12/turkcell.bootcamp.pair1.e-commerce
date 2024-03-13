package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.responses.ProductHowManySoldResponse;

import java.util.List;

public interface OrdersProductService {
    int howManySoldById(int id);
    List<ProductHowManySoldResponse> howManySold();
}
