package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrderService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.request.OrderAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.response.OrderGetAllResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderGetAllResponse> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    void add(@RequestBody @Valid OrderAddRequest orderAddRequest) {
        orderService.add(orderAddRequest);
    }
}
