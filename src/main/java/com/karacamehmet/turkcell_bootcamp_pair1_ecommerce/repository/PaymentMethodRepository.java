package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
}