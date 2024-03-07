package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAll();

    Optional<Order> getById(int id);

    void add(Order order);

    void update(Order order);

    void deleteById(int id);
}
