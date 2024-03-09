package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CartProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService {
    private final CartProductRepository cartProductRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public List<CartProduct> getAll() {
        return cartProductRepository.findAll();
    }

    @Override
    public Optional<CartProduct> getById(int id) {
        return cartProductRepository.findById(id);
    }

    @Override
    public void add(CartProduct cartProduct) {
        cartProductRepository.save(cartProduct);
    }

    @Override
    public void update(CartProduct cartProduct) {

    }

    @Override
    public void deleteById(int id) {
        cartProductRepository.deleteById(id);
    }
}
