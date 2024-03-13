package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.request.AddWishlistRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.response.WishlistNonUpdatedResponse;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    List<Wishlist> getAll();

    Optional<Wishlist> getById(int id);

    Wishlist add(AddWishlistRequest wishlist);

    void update(Wishlist wishlist);

    void deleteById(int id);
    List<WishlistNonUpdatedResponse> getNonUpdatedWishlist();
}
