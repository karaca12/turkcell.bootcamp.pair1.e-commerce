package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoriesProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.response.AddressGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.response.CategoriesProductGetAllResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoriesProduct")
public class CategoriesProductController {
    private final CategoriesProductService categoriesProductService;

    public CategoriesProductController(CategoriesProductService categoriesProductService) {
        this.categoriesProductService = categoriesProductService;
    }

    @GetMapping()
    List<CategoriesProductGetAllResponse> getAll() {
        return categoriesProductService.getAll();
    }
}
