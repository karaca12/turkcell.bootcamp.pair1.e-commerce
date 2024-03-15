package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.OrdersProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.OrdersProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrdersProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.request.OrdersProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.response.OrdersProductGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductHowManySoldResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.OrdersProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersProductServiceImpl implements OrdersProductService {
    private final OrdersProductRepository ordersProductRepository;

    public OrdersProductServiceImpl(OrdersProductRepository ordersProductRepository) {
        this.ordersProductRepository = ordersProductRepository;
    }

    @Override
    public List<OrdersProductGetAllResponse> getAll() {
        List<OrdersProduct> ordersProducts = ordersProductRepository.findAll();
        return OrdersProductMapper.INSTANCE.ordersProductGetAllResponseListFromOrdersProductList(ordersProducts);
    }

    @Override
    public void add(OrdersProductAddRequest ordersProductsAddRequest) {
        ordersProductRepository.findById(ordersProductsAddRequest.getOrderId()).orElseThrow(() -> new BusinessException("Order not found"));
        ordersProductRepository.findById(ordersProductsAddRequest.getProductId()).orElseThrow(() -> new BusinessException("Product not found"));
        OrdersProduct ordersProduct = OrdersProductMapper.INSTANCE.ordersProductFromAddRequest(ordersProductsAddRequest);
        ordersProductRepository.save(ordersProduct);
    }

    @Override
    public int howManySoldById(int id) {
        return ordersProductRepository.howManySoldById(id);
    }

    @Override
    public List<ProductHowManySoldResponse> howManySold() {
        return ordersProductRepository.howManySold();
    }
}
