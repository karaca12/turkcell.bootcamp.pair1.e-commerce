package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.request.OrderAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.order.response.OrderGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "customerId", target = "customerId.id")
    @Mapping(source = "addressId", target = "addressId.id")
    Order orderFromAddRequest(OrderAddRequest orderAddRequest);

    @Mapping(source = "customerId.id", target = "customerId")
    @Mapping(source = "addressId.id", target = "addressId")
    OrderGetAllResponse orderGetAllResponseFromOrder(Order order);

    List<OrderGetAllResponse> orderGetAllResponseListFromOrderList(List<Order> orders);
}