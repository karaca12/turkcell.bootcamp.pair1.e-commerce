package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Payment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.request.PaymentAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.response.PaymentGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<PaymentGetAllResponse> getAll();

    Optional<Payment> getById(int id);

    void add(PaymentAddRequest paymentAddRequest);

    void update(Payment payment);

    void deleteById(int id);
}
