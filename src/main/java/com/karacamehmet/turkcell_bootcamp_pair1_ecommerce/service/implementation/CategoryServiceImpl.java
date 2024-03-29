package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CategoryRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.request.CategoryAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryNumberOfProductsResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

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
        return CategoryMapper.INSTANCE.categoryGetAllResponseListFromCategoryList(categories);
    }

    @Override
    public Optional<Category> getById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void add(CategoryAddRequest categoryAddRequest) {
        categoryWithSameNameShouldNotExist(categoryAddRequest.getName());
        Category category = CategoryMapper.INSTANCE.categoryFromAddRequest(categoryAddRequest);
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

    private void categoryWithSameNameShouldNotExist(String name) {
        Optional<Category> optionalCategory = categoryRepository.findByName(name);
        if (optionalCategory.isPresent()) {
            throw new BusinessException("This category already exists");
        }
    }
}
