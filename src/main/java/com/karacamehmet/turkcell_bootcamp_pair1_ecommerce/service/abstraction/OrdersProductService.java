package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.dto.product.response.ProductHowManySoldResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersProductService {
    int howManySoldById(int id);
    List<ProductHowManySoldResponse> howManySold();
}
