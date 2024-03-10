package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductPriceChangedResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;



    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }
    @GetMapping("/raisedproducts")
    public List<ProductPriceChangedResponse> getProductsWithRaisedPrice(){
        return productService.getProductsWithRaisedPrice();
    }
    @GetMapping("/discountedproducts")
    public List<ProductPriceChangedResponse> getProductsWithDiscount(){
        return productService.getProductsWithDiscount();
    }
    @GetMapping("/maxprice")
    public Product findTopByOrderByPriceDesc(){
        return productService.findTopByOrderByPriceDesc();
    }


}
