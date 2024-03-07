package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.WishlistRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public List<Wishlist> getAll() {
        return wishlistRepository.findAll();
    }

    @Override
    public Optional<Wishlist> getById(int id) {
        return wishlistRepository.findById(id);
    }

    @Override
    public void add(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }

    @Override
    public void update(Wishlist wishlist) {

    }

    @Override
    public void deleteById(int id) {
        wishlistRepository.deleteById(id);
    }
}
