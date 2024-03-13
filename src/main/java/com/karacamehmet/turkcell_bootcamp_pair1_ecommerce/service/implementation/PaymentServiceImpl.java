package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Payment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.PaymentRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrderService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentMethodService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.request.PaymentAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.response.PaymentGetAllResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMethodService paymentMethodService;
    private final OrderService orderService;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMethodService paymentMethodService, OrderService orderService) {
        this.paymentRepository = paymentRepository;
        this.paymentMethodService = paymentMethodService;
        this.orderService = orderService;
    }

    @Override
    public List<PaymentGetAllResponse> getAll() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentGetAllResponse> response = new ArrayList<>();
        for (Payment payment : payments) {
            PaymentGetAllResponse dto = new PaymentGetAllResponse(payment.getId(), payment.getOrderId().getId(), payment.getPaymentMethod().getId(), payment.getAmount(), payment.getDate(), payment.getStatus());
            response.add(dto);
        }
        return response;
    }

    @Override
    public Optional<Payment> getById(int id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void add(PaymentAddRequest paymentAddRequest) {
        Payment payment = new Payment();
        payment.setAmount(paymentAddRequest.getAmount());
        payment.setDate(paymentAddRequest.getDate());
        payment.setStatus(paymentAddRequest.getStatus());
        findPaymentMethodAndOrderByIdAndAddItToPayment(paymentAddRequest.getPaymentMethodId(), paymentAddRequest.getOrderId(), payment);
        paymentRepository.save(payment);
    }

    @Override
    public void update(Payment payment) {
    }

    @Override
    public void deleteById(int id) {
        paymentRepository.deleteById(id);
    }

    private void findPaymentMethodAndOrderByIdAndAddItToPayment(Integer paymentMethodId, Integer orderId, Payment payment) {
        PaymentMethod paymentMethod = paymentMethodService.getById(paymentMethodId).orElseThrow(() -> new BusinessException("There is an issue finding the payment method"));
        payment.setPaymentMethod(paymentMethod);

        Order order = orderService.getById(orderId).orElseThrow(() -> new BusinessException("There is an issue finding the order"));
        payment.setOrderId(order);
    }
}
