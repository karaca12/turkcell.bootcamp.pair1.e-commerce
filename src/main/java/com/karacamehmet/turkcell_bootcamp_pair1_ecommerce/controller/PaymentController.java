package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.request.PaymentAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.response.PaymentGetAllResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentGetAllResponse> getAll() {
        return paymentService.getAll();
    }

    @PostMapping
    void add(@RequestBody @Valid PaymentAddRequest paymentAddRequest) {
        paymentService.add(paymentAddRequest);
    }
}
