package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.request.OrderAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.response.OrderGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderGetAllResponse> getAll();

    Optional<Order> getById(int id);

    void add(OrderAddRequest orderAddRequest);

    void update(Order order);

    void deleteById(int id);
}