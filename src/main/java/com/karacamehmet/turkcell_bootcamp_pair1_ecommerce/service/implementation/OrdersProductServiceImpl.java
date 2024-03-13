package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.OrdersProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.OrdersProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrderService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrdersProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.request.OrdersProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.ordersproduct.response.OrdersProductGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductHowManySoldResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersProductServiceImpl implements OrdersProductService {
    private final OrdersProductRepository ordersProductRepository;
    private final OrderService orderService;
    private final ProductService productService;

    public OrdersProductServiceImpl(OrdersProductRepository ordersProductRepository, OrderService orderService, ProductService productService) {
        this.ordersProductRepository = ordersProductRepository;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public List<OrdersProductGetAllResponse> getAll() {
        List<OrdersProduct> ordersProducts = ordersProductRepository.findAll();
        List<OrdersProductGetAllResponse> response = new ArrayList<>();
        for (OrdersProduct ordersProduct : ordersProducts) {
            OrdersProductGetAllResponse dto = new OrdersProductGetAllResponse(ordersProduct.getId(), ordersProduct.getOrderId().getId(), ordersProduct.getProductId().getId(), ordersProduct.getQuantity(), ordersProduct.getPrice());
            response.add(dto);
        }
        return response;
    }

    @Override
    public void add(OrdersProductAddRequest ordersProductsAddRequest) {
        OrdersProduct ordersProduct = new OrdersProduct();
        ordersProduct.setPrice(ordersProductsAddRequest.getPrice());
        ordersProduct.setQuantity(ordersProductsAddRequest.getQuantity());
        findOrderAndProductByIdAndAddItToOrdersProduct(ordersProductsAddRequest.getOrderId(), ordersProductsAddRequest.getProductId(), ordersProduct);
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

    private void findOrderAndProductByIdAndAddItToOrdersProduct(Integer orderId, Integer productId, OrdersProduct ordersProduct) {
        Order order = orderService.getById(orderId).orElseThrow(() -> new BusinessException("There is an issue finding the order"));
        ordersProduct.setOrderId(order);

        Product product = productService.getById(productId).orElseThrow(() -> new BusinessException("There is an issue finding the product"));
        ordersProduct.setProductId(product);
    }
}
