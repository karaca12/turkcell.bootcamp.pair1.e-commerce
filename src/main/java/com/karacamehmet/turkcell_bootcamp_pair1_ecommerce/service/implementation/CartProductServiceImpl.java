package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CartProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.response.CartProductGetAllResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService {
    private final CartProductRepository cartProductRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public List<CartProductGetAllResponse> getAll() {
        List<CartProduct> cartProducts = cartProductRepository.findAll();
        List<CartProductGetAllResponse> response = new ArrayList<>();
        for (CartProduct cartProduct :
                cartProducts) {
            CartProductGetAllResponse dto = new CartProductGetAllResponse(
                    cartProduct.getId(), cartProduct.getCart().getId(),
                    cartProduct.getProductId().getId(), cartProduct.getQuantity(),
                    cartProduct.getAddedAt());
            response.add(dto);
        }
        return response;
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
