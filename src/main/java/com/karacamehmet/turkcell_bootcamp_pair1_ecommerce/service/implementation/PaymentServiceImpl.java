package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Payment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.PaymentRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.response.HowManyCashPaymentsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getById(int id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void add(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void update(Payment payment) {

    }

    @Override
    public void deleteById(int id) {
        paymentRepository.deleteById(id);
    }

}
