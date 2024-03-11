package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CategoriesProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CategoriesProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoriesProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.response.CategoriesProductGetAllResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesProductServiceImpl implements CategoriesProductService {
    private final CategoriesProductRepository categoriesProductRepository;

    public CategoriesProductServiceImpl(CategoriesProductRepository categoriesProductRepository) {
        this.categoriesProductRepository = categoriesProductRepository;
    }

    @Override
    public List<CategoriesProductGetAllResponse> getAll() {
        List<CategoriesProduct> categoriesProducts = categoriesProductRepository.findAll();
        List<CategoriesProductGetAllResponse> response = new ArrayList<>();
        for (CategoriesProduct categoriesProduct :
                categoriesProducts) {
            CategoriesProductGetAllResponse dto = new CategoriesProductGetAllResponse(categoriesProduct.getId(), categoriesProduct.getCategoryId().getId(), categoriesProduct.getProductId().getId());
            response.add(dto);
        }
        return response;
    }

    @Override
    public Optional<CategoriesProduct> getById(int id) {
        return categoriesProductRepository.findById(id);
    }

    @Override
    public void add(CategoriesProduct categoriesProduct) {
        categoriesProductRepository.save(categoriesProduct);
    }

    @Override
    public void update(CategoriesProduct categoriesProduct) {

    }

    @Override
    public void deleteById(int id) {
        categoriesProductRepository.deleteById(id);
    }
}