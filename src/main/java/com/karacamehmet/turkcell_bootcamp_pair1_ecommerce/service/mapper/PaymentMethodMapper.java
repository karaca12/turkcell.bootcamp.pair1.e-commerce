package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.request.PaymentMethodAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.paymentmethod.response.PaymentMethodGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentMethodMapper {
    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

    PaymentMethod paymentMethodFromAddRequest(PaymentMethodAddRequest paymentMethodAddRequest);

    PaymentMethodGetAllResponse paymentMethodGetAllResponseFromPaymentMethod(PaymentMethod paymentMethod);

    List<PaymentMethodGetAllResponse> paymentMethodGetAllResponseListFromPaymentMethodList(List<PaymentMethod> paymentMethods);
}