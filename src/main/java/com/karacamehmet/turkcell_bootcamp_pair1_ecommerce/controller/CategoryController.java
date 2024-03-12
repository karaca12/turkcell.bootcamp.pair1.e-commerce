package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cart.request.CartAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.request.CategoryAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryNumberOfProductsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<CategoryGetAllResponse> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/categoriesByNumberOfProducts")
    List<CategoryNumberOfProductsResponse> getCategoriesByNumberOfProducts() {
        return categoryService.getCategoriesByNumberOfProducts();
    }

    @PostMapping
    void add(@RequestBody @Valid CategoryAddRequest categoryAddRequest) {
        categoryService.add(categoryAddRequest);
    }
}
