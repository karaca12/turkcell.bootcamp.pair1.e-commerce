package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Cart;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CartRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.CartAddRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CustomerService customerService;

    public CartServiceImpl(CartRepository cartRepository, CustomerService customerService) {
        this.cartRepository = cartRepository;
        this.customerService = customerService;
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public void add(CartAddRequest cartAddRequest) {
        Cart cart=new Cart();
        cart.setCreatedAt(cartAddRequest.getCreatedAt());
        cart.setUpdatedAt(cartAddRequest.getUpdatedAt());
        findCustomerByIdAndAddItToCart(cartAddRequest.getCustomerId(),cart);
        cartRepository.save(cart);
    }



    @Override
    public void update(Cart cart) {

    }

    @Override
    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }

    private void findCustomerByIdAndAddItToCart(Integer customerId, Cart cart) {
        Customer customer = customerService.getById(customerId).orElseThrow(()->new BusinessException("There is already a cart with this customer"));
        cart.setCustomer(customer);
    }
}
