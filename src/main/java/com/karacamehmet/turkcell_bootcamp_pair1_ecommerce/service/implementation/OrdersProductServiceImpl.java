package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.dto.product.response.ProductHowManySoldResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.OrdersProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrdersProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersProductServiceImpl implements OrdersProductService {
    private final OrdersProductRepository ordersProductRepository;

    public OrdersProductServiceImpl(OrdersProductRepository ordersProductRepository) {
        this.ordersProductRepository = ordersProductRepository;
    }

    @Override
    public int howManySoldById(int id) {
        return ordersProductRepository.howManySoldById(id);
    }

    @Override
    public List<ProductHowManySoldResponse> howManySold() {
        return ordersProductRepository.howManySold();
    }
}
