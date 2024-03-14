package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Cart;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CartRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CartService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CustomerService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.response.CartGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.request.CartAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.CartMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CustomerService customerService;

    public CartServiceImpl(CartRepository cartRepository, CustomerService customerService) {
        this.cartRepository = cartRepository;
        this.customerService = customerService;
    }

    @Override
    public List<CartGetAllResponse> getAll() {
        List<Cart> carts = cartRepository.findAll();
        return CartMapper.INSTANCE.cartGetAllResponseListFromCartList(carts);
    }

    @Override
    public Optional<Cart> getById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public void add(CartAddRequest cartAddRequest) {
        checkIfCustomerAlreadyHasCart(cartAddRequest.getCustomerId());
        Cart cart = CartMapper.INSTANCE.cartFromAddRequest(cartAddRequest);
        cartRepository.save(cart);
    }


    @Override
    public void update(Cart cart) {

    }

    @Override
    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }

    private void checkIfCustomerAlreadyHasCart(Integer customerId) {
        Optional<Customer> customerOptional = customerService.getById(customerId);
        customerOptional.ifPresent(customer -> {
            if (cartRepository.findByCustomer(customer).isPresent()) {
                throw new BusinessException("There is already a cart with this customer");
            }
        });
    }
}
