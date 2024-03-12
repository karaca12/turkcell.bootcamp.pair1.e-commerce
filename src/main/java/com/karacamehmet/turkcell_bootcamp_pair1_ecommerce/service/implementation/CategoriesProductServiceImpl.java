package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Cart;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CategoriesProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CategoriesProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoriesProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.request.CategoriesProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.response.CategoriesProductGetAllResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesProductServiceImpl implements CategoriesProductService {
    private final CategoriesProductRepository categoriesProductRepository;
    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoriesProductServiceImpl(CategoriesProductRepository categoriesProductRepository, CategoryService categoryService, ProductService productService) {
        this.categoriesProductRepository = categoriesProductRepository;
        this.categoryService = categoryService;
        this.productService = productService;
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
    public void add(CategoriesProductAddRequest categoriesProductAddRequest) {
        CategoriesProduct categoriesProduct = new CategoriesProduct();
        findCategoryAndProductByIdAndAddItToTheCategoriesProduct(categoriesProductAddRequest.getCategoryId(),categoriesProductAddRequest.getProductId(),categoriesProduct);

        categoriesProductRepository.save(categoriesProduct);
    }

    @Override
    public void update(CategoriesProduct categoriesProduct) {

    }

    @Override
    public void deleteById(int id) {
        categoriesProductRepository.deleteById(id);
    }
    private void findCategoryAndProductByIdAndAddItToTheCategoriesProduct(Integer categoryId, Integer productId, CategoriesProduct categoriesProduct) {
        Category category = categoryService.getById(categoryId).orElseThrow(()->new BusinessException("There is an issue finding the category"));
        categoriesProduct.setCategoryId(category);

        Product product = productService.getById(productId).orElseThrow(()->new BusinessException("There is an issue finding the product"));
        categoriesProduct.setProductId(product);
    }
}