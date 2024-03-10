package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.WishlistsItem;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.WishlistsItemRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.WishlistsItemService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.response.ProductsAddedToWishlistResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistsItemServiceImpl implements WishlistsItemService {
    private final WishlistsItemRepository wishlistsItemRepository;

    public WishlistsItemServiceImpl(WishlistsItemRepository wishlistsItemRepository) {
        this.wishlistsItemRepository = wishlistsItemRepository;
    }

    @Override
    public List<WishlistsItem> getAll() {
        return wishlistsItemRepository.findAll();
    }

    @Override
    public Optional<WishlistsItem> getById(int id) {
        return wishlistsItemRepository.findById(id);
    }

    @Override
    public void add(WishlistsItem wishlistsItem) {
        wishlistsItemRepository.save(wishlistsItem);
    }

    @Override
    public void update(WishlistsItem wishlistsItem) {

    }

    @Override
    public void deleteById(int id) {
        wishlistsItemRepository.deleteById(id);
    }

    @Override
    public List<ProductsAddedToWishlistResponse> howManyAdded() {
        return wishlistsItemRepository.howManyAdded();
    }
}
