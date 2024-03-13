package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.requests.AddProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.requests.UpdateProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.responses.ProductListResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.responses.ProductPriceChangedResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;



    @GetMapping
    public List<ProductListResponse> getAll() {
        return productService.getAll();
    }
    @GetMapping("/priceGoneUp")
    public List<ProductPriceChangedResponse> getProductsWithPriceGoneUp(){
        return productService.getProductsWithPriceGoneUp();
    }
    @GetMapping("/priceWentDown")
    public List<ProductPriceChangedResponse> getProductsWithPriceWentDown(){
        return productService.getProductsWithPriceWentDown();
    }
    @GetMapping("/maxPrice")
    public Product findTopByOrderByPriceDesc(){
        return productService.findTopByOrderByPriceDesc();
    }
    @PostMapping("/addProduct")
    public void add(@RequestBody @Valid AddProductRequest addProductRequest){
        productService.add(addProductRequest);
    }
    @PutMapping("/updateProduct")
    public void update(@RequestBody UpdateProductRequest updateProductRequest){
        productService.update(updateProductRequest);
    }



}
