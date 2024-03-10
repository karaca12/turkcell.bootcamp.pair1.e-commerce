package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentMethodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paymentmethods")
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping()
    List<PaymentMethod> getAll() {
        return paymentMethodService.getAll();
    }

    @GetMapping("/{id}")
    Optional<PaymentMethod> getById(@PathVariable int id) {
        return paymentMethodService.getById(id);
    }

    @PostMapping
    void add(@RequestBody PaymentMethod paymentMethod) {
        paymentMethodService.add(paymentMethod);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        paymentMethodService.deleteById(id);
    }

    @GetMapping("/totalTransactions/cash")
    int getTotalTransactionsCash() {
        return paymentMethodService.getTotalTransactionsCash();
    }
}
