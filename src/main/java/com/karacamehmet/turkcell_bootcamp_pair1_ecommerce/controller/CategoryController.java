package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryNumberOfProductsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/categoriesByNumberOfProducts")
    List<CategoryNumberOfProductsResponse> getCategoriesByNumberOfProducts() {
        return categoryService.getCategoriesByNumberOfProducts();
    }
}
