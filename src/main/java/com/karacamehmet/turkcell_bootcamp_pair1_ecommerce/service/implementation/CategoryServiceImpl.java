package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CategoryRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryNumberOfProductsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryGetAllResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryGetAllResponse> response = new ArrayList<>();
        for (Category category :
                categories) {
            CategoryGetAllResponse dto = new CategoryGetAllResponse(
                    category.getId(), category.getName(), category.getDescription());
            response.add(dto);
        }
        return response;
    }

    @Override
    public Optional<Category> getById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryNumberOfProductsResponse> getCategoriesByNumberOfProducts() {
        return categoryRepository.getCategoriesByNumberOfProducts();
    }
}
