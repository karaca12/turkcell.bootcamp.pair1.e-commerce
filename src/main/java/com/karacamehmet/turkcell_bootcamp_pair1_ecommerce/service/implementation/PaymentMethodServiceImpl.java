package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.PaymentMethodRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentMethodService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.request.PaymentMethodAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.response.PaymentMethodGetAllResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<PaymentMethodGetAllResponse> getAll() {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        List<PaymentMethodGetAllResponse> response = new ArrayList<>();
        for (PaymentMethod paymentMethod : paymentMethods) {
            PaymentMethodGetAllResponse dto = new PaymentMethodGetAllResponse(paymentMethod.getId(), paymentMethod.getName());
            response.add(dto);
        }
        return response;
    }

    @Override
    public Optional<PaymentMethod> getById(int id) {
        return paymentMethodRepository.findById(id);
    }

    @Override
    public void add(PaymentMethodAddRequest paymentMethodAddRequest) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(paymentMethodAddRequest.getName());
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
