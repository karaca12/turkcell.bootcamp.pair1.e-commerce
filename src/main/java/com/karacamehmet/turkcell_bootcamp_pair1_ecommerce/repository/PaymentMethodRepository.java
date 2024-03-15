package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
    @Query(value = "select count(*) as cash_count from payment p " +
            "join payment_methods pm on p.payment_method_id=pm.id " +
            "where pm.name='Cash'", nativeQuery = true)
    int getTotalTransactionsCash();

    Optional<PaymentMethod> findByName(String name);
}