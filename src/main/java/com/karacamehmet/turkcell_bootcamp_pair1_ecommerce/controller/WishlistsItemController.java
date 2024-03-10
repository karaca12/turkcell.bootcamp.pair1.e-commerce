package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.WishlistsItem;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.WishlistsItemService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.response.ProductsAddedToWishlistResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlistsitems")
public class WishlistsItemController {
    private final WishlistsItemService wishlistsItemService;

    public WishlistsItemController(WishlistsItemService wishlistsItemService) {
        this.wishlistsItemService = wishlistsItemService;
    }

    @GetMapping()
    List<WishlistsItem> getAll() {
        return wishlistsItemService.getAll();
    }

    @GetMapping("/{id}")
    Optional<WishlistsItem> getById(@PathVariable int id) {
        return wishlistsItemService.getById(id);
    }

    @PostMapping
    void add(@RequestBody WishlistsItem wishlistsItem) {
        wishlistsItemService.add(wishlistsItem);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        wishlistsItemService.deleteById(id);
    }

    @GetMapping("/howManyProductsAdded")
    public List<ProductsAddedToWishlistResponse> howManyProductsAdded() { return wishlistsItemService.howManyProductsAdded();}
}

