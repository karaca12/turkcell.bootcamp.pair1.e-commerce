package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.WishlistsItem;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.ProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.WishlistRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.WishlistsItemRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.WishlistsItemService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.request.AddWishlistsItemRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.response.ProductsAddedToWishlistResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.WishlistsItemMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistsItemServiceImpl implements WishlistsItemService {
    private final WishlistsItemRepository wishlistsItemRepository;
    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;

    public WishlistsItemServiceImpl(WishlistsItemRepository wishlistsItemRepository, WishlistRepository wishlistRepository
    , ProductRepository productRepository) {
        this.wishlistsItemRepository = wishlistsItemRepository;
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
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
    public WishlistsItem add(AddWishlistsItemRequest wishlistsItem) {
        Wishlist wishlist = wishlistRepository.findById(wishlistsItem.getWishlistId())
                .orElseThrow(() -> new EntityNotFoundException("Wishlist not found"));
        Product product = productRepository.findById(wishlistsItem.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        WishlistsItem newWishlistsItem = WishlistsItemMapper.INSTANCE.addWishlistsItemRequestToWishlistsItem(wishlistsItem);

        newWishlistsItem.setWishlistId(wishlist);
        newWishlistsItem.setProductId(product);
        return wishlistsItemRepository.save(newWishlistsItem);
    }

    @Override
    public void update(WishlistsItem wishlistsItem) {

    }

    @Override
    public void deleteById(int id) {
        wishlistsItemRepository.deleteById(id);
    }

    @Override
    public List<ProductsAddedToWishlistResponse> howManyProductsAdded() {
        return wishlistsItemRepository.howManyProductsAdded();
    }
}
