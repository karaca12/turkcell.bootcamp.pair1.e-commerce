package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryNumberOfProductsResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryGetAllResponse> getAll();

    Optional<Category> getById(int id);

    void add(Category category);

    void update(Category category);

    void deleteById(int id);
    List<CategoryNumberOfProductsResponse> getCategoriesByNumberOfProducts();
}
