package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Payment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.response.HowManyCashPaymentsResponse;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> getAll();

    Optional<Payment> getById(int id);

    void add(Payment payment);

    void update(Payment payment);

    void deleteById(int id);

    List<HowManyCashPaymentsResponse> countPaymentsDoneWithCash();
}
