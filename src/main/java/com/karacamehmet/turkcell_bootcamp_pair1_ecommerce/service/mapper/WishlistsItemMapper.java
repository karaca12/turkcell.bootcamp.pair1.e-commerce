package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.WishlistsItem;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.request.AddWishlistsItemRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WishlistsItemMapper {
    WishlistsItemMapper INSTANCE = Mappers.getMapper(WishlistsItemMapper.class);

    @Mapping(source = "wishlistId", target = "wishlistId.id")
    @Mapping(source = "productId", target = "productId.id")
    WishlistsItem addWishlistsItemRequestToWishlistsItem(AddWishlistsItemRequest addWishlistsItemRequest);
}
