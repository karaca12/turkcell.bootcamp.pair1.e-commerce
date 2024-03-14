package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.request.CategoryAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.category.response.CategoryGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryFromAddRequest(CategoryAddRequest categoryAddRequest);

    CategoryGetAllResponse categoryGetAllResponseFromCategory(Category category);

    List<CategoryGetAllResponse> categoryGetAllResponseListFromCategoryList(List<Category> categories);
}
