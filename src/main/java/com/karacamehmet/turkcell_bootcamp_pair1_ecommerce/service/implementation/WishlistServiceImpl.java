package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.WishlistRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.WishlistService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.WishlistNonUpdatedResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<WishlistNonUpdatedResponse> getNonUpdatedWishlist() {
        List<Wishlist> wishlists = wishlistRepository.getNonUpdatedWishlist();
        List<WishlistNonUpdatedResponse> response = new ArrayList<>();
        for (Wishlist wishlist :
                wishlists) {
            WishlistNonUpdatedResponse dto = new
                    WishlistNonUpdatedResponse(wishlist.getId(),
                    wishlist.getCustomerId().getId(),
                    wishlist.getCustomerId().getUsers().getName(),
                    wishlist.getCustomerId().getLastName());
            response.add(dto);
        }
        return response;
    }
}
