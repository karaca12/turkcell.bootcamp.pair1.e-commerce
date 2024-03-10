package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveProductsInCartResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByOrdersNull();
    @Query("SELECT new com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomersWithMoreThanFiveProductsInCartResponse" +
            "(u.id, u.name, u.customer.lastName, SUM(cp.quantity)) FROM User u, CartProduct cp " +
            "WHERE u.customer.id = u.id " +
            "AND u.customer.cart.customer.id = u.customer.id " +
            "AND u.customer.cart.id = cp.cart.id " +
            "GROUP BY cp.cart.id, u.id, u.customer.lastName " +
            "HAVING SUM(cp.quantity) > 5")
    List<CustomersWithMoreThanFiveProductsInCartResponse> getCustomersWithMoreThanFiveProductsInCart();
}