package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.PaymentMethodRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public Optional<PaymentMethod> getById(int id) {
        return paymentMethodRepository.findById(id);
    }

    @Override
    public void add(PaymentMethod paymentMethod) {
        paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void update(PaymentMethod paymentMethod) {

    }

    @Override
    public void deleteById(int id) {
        paymentMethodRepository.deleteById(id);
    }

    @Override
    public int getTotalTransactionsCash() {
        return paymentMethodRepository.getTotalTransactionsCash();
    }
}
