package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.request;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AddWishlistsItemRequest {
    private int id;
    @NotNull
    private Wishlist wishlistId;
    @NotNull
    private Product productId;
    @Min(1)
    private int quantity;
}
