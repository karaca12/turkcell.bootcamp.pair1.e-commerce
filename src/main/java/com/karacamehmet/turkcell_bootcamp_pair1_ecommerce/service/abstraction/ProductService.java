package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.request.AddProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.request.UpdateProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductListResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductPriceChangedResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductListResponse> getAll();

    Optional<Product> getById(int id);

    void add(AddProductRequest addProductRequest);

    void update(UpdateProductRequest updateProductRequest);

    void deleteById(int id);
    List<ProductPriceChangedResponse> getProductsWithPriceGoneUp();
    List<ProductPriceChangedResponse> getProductsWithPriceWentDown();
    Product findTopByOrderByPriceDesc();

}
