package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Payment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.request.PaymentAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.payment.response.PaymentGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "orderId", target = "orderId.id")
    @Mapping(source = "paymentMethodId", target = "paymentMethod.id")
    Payment paymentFromAddRequest(PaymentAddRequest paymentAddRequest);

    @Mapping(source = "paymentMethod.id", target = "paymentMethodId")
    @Mapping(source = "orderId.id", target = "orderId")
    PaymentGetAllResponse paymentGetAllResponseFromPayment(Payment payment);

    List<PaymentGetAllResponse> paymentGetAllResponseListFromPaymentList(List<Payment> payments);
}