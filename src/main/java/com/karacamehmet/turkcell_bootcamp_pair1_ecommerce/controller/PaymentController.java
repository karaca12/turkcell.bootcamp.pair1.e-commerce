package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Payment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.response.HowManyCashPaymentsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

}
