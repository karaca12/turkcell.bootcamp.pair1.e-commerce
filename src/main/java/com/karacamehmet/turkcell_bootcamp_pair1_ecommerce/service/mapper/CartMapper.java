package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Cart;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.request.CartAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.request.CartUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.response.CartGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE= Mappers.getMapper(CartMapper.class);


    @Mapping(source = "customerId",target = "customer.id")
    Cart cartFromAddRequest(CartAddRequest cartAddRequest);

    @Mapping(source = "customer.id",target = "customerId")
    CartGetAllResponse cartGetAllResponseFromCart(Cart cart);

    List<CartGetAllResponse> cartGetAllResponseListFromCartList(List<Cart> carts);

    @Mapping(source = "updatedId", target = "id")
    Cart cartFromUpdateRequest(CartUpdateRequest cartUpdateRequest);
}
