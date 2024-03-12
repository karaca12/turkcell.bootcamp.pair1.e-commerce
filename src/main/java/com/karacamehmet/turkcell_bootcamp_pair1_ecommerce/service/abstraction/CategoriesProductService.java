package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CategoriesProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.request.CategoriesProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.response.CategoriesProductGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface CategoriesProductService {
    List<CategoriesProductGetAllResponse> getAll();

    Optional<CategoriesProduct> getById(int id);

    void add(CategoriesProductAddRequest categoriesProductAddRequest);

    void update(CategoriesProduct categoriesProduct);

    void deleteById(int id);
}