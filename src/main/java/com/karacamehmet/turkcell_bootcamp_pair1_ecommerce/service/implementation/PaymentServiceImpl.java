package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Payment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.PaymentRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.request.PaymentAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.response.PaymentGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.PaymentMapper;
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
    public List<PaymentGetAllResponse> getAll() {
        List<Payment> payments = paymentRepository.findAll();
        return PaymentMapper.INSTANCE.paymentGetAllResponseListFromPaymentList(payments);
    }

    @Override
    public Optional<Payment> getById(int id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void add(PaymentAddRequest paymentAddRequest) {
        paymentRepository.findById(paymentAddRequest.getOrderId()).orElseThrow(() -> new BusinessException("Order not found"));
        paymentRepository.findById(paymentAddRequest.getPaymentMethodId()).orElseThrow(() -> new BusinessException("Payment method not found"));
        Payment payment = PaymentMapper.INSTANCE.paymentFromAddRequest(paymentAddRequest);
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
