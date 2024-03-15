package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.PaymentMethodRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.PaymentMethodService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.request.PaymentMethodAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.response.PaymentMethodGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.PaymentMethodMapper;
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
    public List<PaymentMethodGetAllResponse> getAll() {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        return PaymentMethodMapper.INSTANCE.paymentMethodGetAllResponseListFromPaymentMethodList(paymentMethods);
    }

    @Override
    public Optional<PaymentMethod> getById(int id) {
        return paymentMethodRepository.findById(id);
    }

    @Override
    public void add(PaymentMethodAddRequest paymentMethodAddRequest) {
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findByName(paymentMethodAddRequest.getName());
        if (optionalPaymentMethod.isPresent()) {
            throw new BusinessException("This payment method already exists");
        }
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.paymentMethodFromAddRequest(paymentMethodAddRequest);
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
