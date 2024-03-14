package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.CategoriesProduct;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.request.CategoriesProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.response.CategoriesProductGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriesProductMapper {
    CategoriesProductMapper INSTANCE = Mappers.getMapper(CategoriesProductMapper.class);

    @Mapping(source = "categoryId", target = "categoryId.id")
    @Mapping(source = "productId", target = "productId.id")
    CategoriesProduct categoriesProductFromAddRequest(CategoriesProductAddRequest categoriesProductAddRequest);

    @Mapping(source = "categoryId.id", target = "categoryId")
    @Mapping(source = "productId.id", target = "productId")
    CategoriesProductGetAllResponse categoriesProductGetAllResponseFromCategoriesProduct(CategoriesProduct categoriesProduct);

    List<CategoriesProductGetAllResponse> categoriesProductGetAllResponseListFromCategoriesProductList(List<CategoriesProduct> categoriesProducts);
}
