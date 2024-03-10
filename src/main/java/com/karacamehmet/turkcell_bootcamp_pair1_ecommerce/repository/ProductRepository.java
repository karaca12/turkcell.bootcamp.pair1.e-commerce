package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductPriceChangedResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select new com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductPriceChangedResponse" +
            "(p.name,op.price,p.price) from OrdersProduct op join op.productId p where p.price>op.price")
    List<ProductPriceChangedResponse> getProductsWithRaisedPrice();
    @Query(value = "select new com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductPriceChangedResponse" +
            "(p.name,op.price,p.price) from OrdersProduct op join op.productId p where p.price<op.price")
    List<ProductPriceChangedResponse> getProductsWithDiscount();

    //findTopByOrderByPriceDesc
   Product findTopByOrderByPriceDesc();


}