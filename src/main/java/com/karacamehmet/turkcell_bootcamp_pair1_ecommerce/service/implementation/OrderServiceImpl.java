package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.OrderRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.AddressService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrderService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.request.OrderAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.response.OrderGetAllResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final AddressService addressService;


    public OrderServiceImpl(OrderRepository orderRepository, CustomerService customerService, AddressService addressService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.addressService = addressService;
    }

    @Override
    public List<OrderGetAllResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderGetAllResponse> response = new ArrayList<>();
        for (Order order : orders) {
            OrderGetAllResponse dto = new OrderGetAllResponse(order.getId(), order.getCustomerId().getId(), order.getAddressId().getId(), order.getOrderDate(), order.getStatus(), order.getTotalPrice());
            response.add(dto);
        }
        return response;
    }

    @Override
    public Optional<Order> getById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public void add(OrderAddRequest orderAddRequest) {
        Order order = new Order();
        order.setOrderDate(orderAddRequest.getOrderDate());
        order.setStatus(orderAddRequest.getStatus());
        order.setTotalPrice(orderAddRequest.getTotalPrice());
        findCustomerAndAddressByIdAndAddItToOrder(orderAddRequest.getCustomerId(), orderAddRequest.getAddressId(), order);
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    private void findCustomerAndAddressByIdAndAddItToOrder(Integer customerId, Integer addressId, Order order) {
        Customer customer = customerService.getById(customerId).orElseThrow(() -> new BusinessException("There is an issue finding the customer"));
        order.setCustomerId(customer);

        Address address = addressService.getById(addressId).orElseThrow(() -> new BusinessException("There is an issue finding the address"));
        order.setAddressId(address);
    }
}

