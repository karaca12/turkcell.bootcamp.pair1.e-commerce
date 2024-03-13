package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.request.PaymentMethodAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.response.PaymentMethodGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodService {
    List<PaymentMethodGetAllResponse> getAll();

    Optional<PaymentMethod> getById(int id);

    void add(PaymentMethodAddRequest paymentMethodAddRequest);

    void update(PaymentMethod paymentMethod);

    void deleteById(int id);

    int getTotalTransactionsCash();
}
