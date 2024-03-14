package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.request.AddProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.request.UpdateProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "stock", target = "stockQuantity")
    Product productFromAddRequest(AddProductRequest productRequest);

    List<ProductListResponse> productGetAllResponseListFromProductList(List<Product> products);

    @Mapping(source = "updatedId", target = "id")
    @Mapping(source = "stock", target = "stockQuantity")
    @Mapping(source = "supplierId", target = "supplierId.id")
    Product productFromUpdateRequest(UpdateProductRequest updateProductRequest);
}
