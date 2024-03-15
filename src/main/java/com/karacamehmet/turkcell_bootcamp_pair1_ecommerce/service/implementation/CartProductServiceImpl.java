package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CartProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductUpdateRequest;
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
    public void add(CartProductAddRequest cartProductAddRequest) {
        CartProduct cartProduct = CartProductMapper.INSTANCE.cartProductFromAddRequest(cartProductAddRequest);
        cartProductRepository.save(cartProduct);
    }


    @Override
    public void update(CartProductUpdateRequest cartProductUpdateRequest) {
        CartProduct cartProductForCartAndProduct = cartProductRepository.findById(cartProductUpdateRequest.getUpdatedId()).orElseThrow(() -> new BusinessException("Cart with this id doesn't exist"));
        CartProduct cartProduct = CartProductMapper.INSTANCE.cartProductFromUpdateRequest(cartProductUpdateRequest);
        cartProduct.setCart(cartProductForCartAndProduct.getCart());
        cartProduct.setProductId(cartProductForCartAndProduct.getProductId());
        cartProductRepository.save(cartProduct);
    }

    @Override
    public void deleteById(int id) {
        cartProductRepository.deleteById(id);
    }

}
