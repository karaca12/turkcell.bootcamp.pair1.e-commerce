package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CategoriesProduct;

import java.util.List;
import java.util.Optional;

public interface CategoriesProductService {
    List<CategoriesProduct> getAll();

    Optional<CategoriesProduct> getById(int id);

    void add(CategoriesProduct categoriesProduct);

    void update(CategoriesProduct categoriesProduct);

    void deleteById(int id);
}