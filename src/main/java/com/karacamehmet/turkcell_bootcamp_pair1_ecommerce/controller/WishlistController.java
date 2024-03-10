package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.WishlistService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.WishlistNonUpdatedResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping()
    List<Wishlist> getAll() {
        return wishlistService.getAll();
    }

    @GetMapping("/{id}")
    Optional<Wishlist> getById(@PathVariable int id) {
        return wishlistService.getById(id);
    }

    @PostMapping
    void add(@RequestBody Wishlist wishlist) {
        wishlistService.add(wishlist);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        wishlistService.deleteById(id);
    }

    @GetMapping("/nonUpdated")
    List<WishlistNonUpdatedResponse> getNonUpdatedWishlist() {
        return wishlistService.getNonUpdatedWishlist();
    }
}
