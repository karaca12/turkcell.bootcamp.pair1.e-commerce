package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodService {
    List<PaymentMethod> getAll();

    Optional<PaymentMethod> getById(int id);

    void add(PaymentMethod paymentMethod);

    void update(PaymentMethod paymentMethod);

    void deleteById(int id);
}
