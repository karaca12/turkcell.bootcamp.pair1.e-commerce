package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.WishlistsItem;

import java.util.List;
import java.util.Optional;

public interface WishlistsItemService {
    List<WishlistsItem> getAll();

    Optional<WishlistsItem> getById(int id);

    void add(WishlistsItem wishlistsItem);

    void update(WishlistsItem wishlistsItem);

    void deleteById(int id);
}
