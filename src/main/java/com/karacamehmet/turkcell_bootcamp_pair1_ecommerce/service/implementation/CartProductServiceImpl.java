package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CartProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductsAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.response.CartProductGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.CartProductMapper;
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
    public List<CartProductGetAllResponse> getAll() {
        List<CartProduct> cartProducts = cartProductRepository.findAll();
        return CartProductMapper.INSTANCE.cartProductGetAllResponseListFromCartProductList(cartProducts);
    }

    @Override
    public Optional<CartProduct> getById(int id) {
        return cartProductRepository.findById(id);
    }

    @Override
    public void add(CartProductsAddRequest cartProductsAddRequest) {
        CartProduct cartProduct = CartProductMapper.INSTANCE.cartProductFromAddRequest(cartProductsAddRequest);
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
