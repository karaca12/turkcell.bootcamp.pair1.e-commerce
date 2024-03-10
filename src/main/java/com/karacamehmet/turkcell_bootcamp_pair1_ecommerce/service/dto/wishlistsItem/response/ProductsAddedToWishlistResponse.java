package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsAddedToWishlistResponse {
    private int productId;
    private long sum;
}
