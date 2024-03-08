package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.dto.product.response.ProductHowManySoldResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrdersProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ordersproducts")
public class OrdersProductsController {
    private final OrdersProductService ordersProductService;

    public OrdersProductsController(OrdersProductService ordersProductService) {
        this.ordersProductService = ordersProductService;
    }

    @GetMapping("/howManySoldById/{id}")
    public int howManySoldById(@PathVariable int id) {
        return ordersProductService.howManySoldById(id);
    }

    @GetMapping("/howManySold")
    public List<ProductHowManySoldResponse> howManySold() {
        return ordersProductService.howManySold();
    }
}
