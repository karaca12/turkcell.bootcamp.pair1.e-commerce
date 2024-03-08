package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.dto.product.response.ProductHowManySoldResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.OrdersProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersProductRepository extends JpaRepository<OrdersProduct, Integer> {
    @Query(value = "select sum(quantity) from orders_products where product_id = :id",nativeQuery = true)
    int howManySoldById(int id);

    @Query(value = "select new com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.dto.product.response.ProductHowManySoldResponse" +
            "(p.name,sum(op.quantity)) from OrdersProduct op join op.productId p group by p.name")
    List<ProductHowManySoldResponse> howManySold();
}