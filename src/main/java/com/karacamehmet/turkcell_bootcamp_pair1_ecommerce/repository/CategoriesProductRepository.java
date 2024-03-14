package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CategoriesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesProductRepository extends JpaRepository<CategoriesProduct, Integer> {
    Optional<CategoriesProduct> findByCategoryId_IdAndProductId_Id(Integer id, Integer id1);
}
