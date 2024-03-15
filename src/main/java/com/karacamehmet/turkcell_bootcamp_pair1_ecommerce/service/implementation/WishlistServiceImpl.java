package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CustomerRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.WishlistRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.WishlistService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.request.AddWishlistRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.response.WishlistNonUpdatedResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.WishlistMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;
    private final CustomerRepository customerRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository, CustomerRepository customerRepository) {
        this.wishlistRepository = wishlistRepository;
        this.customerRepository = customerRepository;
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
    public Wishlist add(AddWishlistRequest wishlist) {
        Customer customer = customerRepository.findById(wishlist.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        Wishlist newWishlist = WishlistMapper.INSTANCE.addWishlistRequestToWishlist(wishlist);
        // No business rule to check?
        newWishlist.setCustomerId(customer);
        return wishlistRepository.save(newWishlist);
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
