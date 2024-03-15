package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.response.CartProductGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartProductMapper {
    CartProductMapper INSTANCE= Mappers.getMapper(CartProductMapper.class);

    @Mapping(source = "cartId", target = "cart.id")
    @Mapping(source = "productId", target = "productId.id")
    CartProduct cartProductFromAddRequest(CartProductAddRequest cartProductAddRequest);

    @Mapping(source = "cart.id", target = "cartId")
    @Mapping(source = "productId.id", target = "productId")
    CartProductGetAllResponse cartProductGetAllResponseFromCartProduct(CartProduct cartProduct);

    List<CartProductGetAllResponse> cartProductGetAllResponseListFromCartProductList(List<CartProduct> cartProducts);

    @Mapping(source = "updatedId", target = "id")
    CartProduct cartProductFromUpdateRequest(CartProductUpdateRequest cartProductUpdateRequest);
}
