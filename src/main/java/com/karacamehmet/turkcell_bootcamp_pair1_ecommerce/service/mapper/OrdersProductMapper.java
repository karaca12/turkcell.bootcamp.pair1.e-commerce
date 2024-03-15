package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.OrdersProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.request.OrdersProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.response.OrdersProductGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrdersProductMapper {
    OrdersProductMapper INSTANCE = Mappers.getMapper(OrdersProductMapper.class);

    @Mapping(source = "orderId", target = "orderId.id")
    @Mapping(source = "productId", target = "productId.id")
    OrdersProduct ordersProductFromAddRequest(OrdersProductAddRequest ordersProductAddRequest);

    @Mapping(source = "productId.id", target = "productId")
    @Mapping(source = "orderId.id", target = "orderId")
    OrdersProductGetAllResponse ordersProductGetAllResponseFromOrdersProduct(OrdersProduct ordersProduct);

    List<OrdersProductGetAllResponse> ordersProductGetAllResponseListFromOrdersProductList(List<OrdersProduct> ordersProducts);
}