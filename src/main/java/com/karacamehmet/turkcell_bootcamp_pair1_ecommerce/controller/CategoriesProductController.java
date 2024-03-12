package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoriesProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.response.AddressGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.cartproducts.request.CartProductsAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.request.CategoriesProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.response.CategoriesProductGetAllResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    void add(@RequestBody @Valid CategoriesProductAddRequest categoriesProductAddRequest) {
        categoriesProductService.add(categoriesProductAddRequest);
    }
}
