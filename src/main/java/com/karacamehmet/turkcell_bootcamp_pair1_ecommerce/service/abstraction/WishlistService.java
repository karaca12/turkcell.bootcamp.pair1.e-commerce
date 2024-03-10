package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.WishlistNonUpdatedResponse;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    List<Wishlist> getAll();

    Optional<Wishlist> getById(int id);

    void add(Wishlist wishlist);

    void update(Wishlist wishlist);

    void deleteById(int id);
    List<WishlistNonUpdatedResponse> nonUpdatedWishlist();
}
