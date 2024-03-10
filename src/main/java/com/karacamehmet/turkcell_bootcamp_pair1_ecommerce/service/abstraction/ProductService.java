package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductPriceChangedResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getById(int id);

    void add(Product product);

    void update(Product product);

    void deleteById(int id);
    List<ProductPriceChangedResponse> getProductsWithPriceGoneUp();
    List<ProductPriceChangedResponse> getProductsWithPriceWentDown();
    Product findTopByOrderByPriceDesc();

}
