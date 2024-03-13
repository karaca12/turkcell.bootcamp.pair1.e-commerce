package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.WishlistsItem;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.request.AddWishlistsItemRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.response.ProductsAddedToWishlistResponse;

import java.util.List;
import java.util.Optional;

public interface WishlistsItemService {
    List<WishlistsItem> getAll();

    Optional<WishlistsItem> getById(int id);

    WishlistsItem add(AddWishlistsItemRequest wishlistsItem);

    void update(WishlistsItem wishlistsItem);

    void deleteById(int id);

    List<ProductsAddedToWishlistResponse> howManyProductsAdded();
}
