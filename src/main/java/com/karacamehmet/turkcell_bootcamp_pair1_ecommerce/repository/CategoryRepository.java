package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryNumberOfProductsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select new com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryNumberOfProductsResponse" +
            "(c.name,count (p.id)) from Category c join c.products p GROUP BY c.name")
    List<CategoryNumberOfProductsResponse> getCategoriesByNumberOfProducts();
}