package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.OrderRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public void add(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}
