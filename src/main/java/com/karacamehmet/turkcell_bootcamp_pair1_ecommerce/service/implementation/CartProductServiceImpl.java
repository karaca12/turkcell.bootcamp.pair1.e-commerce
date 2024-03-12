package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Cart;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CartProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CartProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductsAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.response.CartProductGetAllResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService {
    private final CartProductRepository cartProductRepository;
    private final CartService cartService;
    private final ProductService productService;

    public CartProductServiceImpl(CartProductRepository cartProductRepository, CartService cartService, ProductService productService) {
        this.cartProductRepository = cartProductRepository;
        this.cartService = cartService;
        this.productService = productService;
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
    public void add(CartProductsAddRequest cartProductsAddRequest) {
        CartProduct cartProduct=new CartProduct();
        cartProduct.setAddedAt(cartProductsAddRequest.getAddedAt());
        cartProduct.setQuantity(cartProductsAddRequest.getQuantity());
        findCartAndProductByIdAndAddItToCartProduct(cartProductsAddRequest.getCartId(),cartProductsAddRequest.getProductId(),cartProduct);

        cartProductRepository.save(cartProduct);
    }



    @Override
    public void update(CartProduct cartProduct) {

    }

    @Override
    public void deleteById(int id) {
        cartProductRepository.deleteById(id);
    }
    private void findCartAndProductByIdAndAddItToCartProduct(Integer cartId, Integer productId, CartProduct cartProduct) {
        Cart cart = cartService.getById(cartId).orElseThrow(()->new BusinessException("There is an issue finding the cart"));
        cartProduct.setCart(cart);

        Product product = productService.getById(productId).orElseThrow(()->new BusinessException("There is an issue finding the product"));
        cartProduct.setProductId(product);
    }
}
