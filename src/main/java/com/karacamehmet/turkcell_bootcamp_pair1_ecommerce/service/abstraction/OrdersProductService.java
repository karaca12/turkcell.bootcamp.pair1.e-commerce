package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.request.OrdersProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.response.OrdersProductGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductHowManySoldResponse;

import java.util.List;

public interface OrdersProductService {
    List<OrdersProductGetAllResponse> getAll();

    void add(OrdersProductAddRequest ordersProductsAddRequest);

    int howManySoldById(int id);

    List<ProductHowManySoldResponse> howManySold();
}
