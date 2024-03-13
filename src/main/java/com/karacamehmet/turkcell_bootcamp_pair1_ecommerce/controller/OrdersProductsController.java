package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrdersProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.request.OrdersProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.response.OrdersProductGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductHowManySoldResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordersproducts")
public class OrdersProductsController {
    private final OrdersProductService ordersProductService;

    public OrdersProductsController(OrdersProductService ordersProductService) {
        this.ordersProductService = ordersProductService;
    }

    @GetMapping
    public List<OrdersProductGetAllResponse> getAll() {
        return ordersProductService.getAll();
    }

    @GetMapping("/howManySoldById/{id}")
    public int howManySoldById(@PathVariable int id) {
        return ordersProductService.howManySoldById(id);
    }

    @GetMapping("/howManySold")
    public List<ProductHowManySoldResponse> howManySold() {
        return ordersProductService.howManySold();
    }

    @PostMapping
    void add(@RequestBody @Valid OrdersProductAddRequest ordersProductAddRequest) {
        ordersProductService.add(ordersProductAddRequest);
    }
}
