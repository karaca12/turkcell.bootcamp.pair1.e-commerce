package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.OrderRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrderService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.request.OrderAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.response.OrderGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderGetAllResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        return OrderMapper.INSTANCE.orderGetAllResponseListFromOrderList(orders);
    }

    @Override
    public Optional<Order> getById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public void add(OrderAddRequest orderAddRequest) {
        orderRepository.findById(orderAddRequest.getCustomerId()).orElseThrow(() -> new BusinessException("Customer not found"));
        orderRepository.findById(orderAddRequest.getAddressId()).orElseThrow(() -> new BusinessException("Address not found"));
        Order order = OrderMapper.INSTANCE.orderFromAddRequest(orderAddRequest);
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

