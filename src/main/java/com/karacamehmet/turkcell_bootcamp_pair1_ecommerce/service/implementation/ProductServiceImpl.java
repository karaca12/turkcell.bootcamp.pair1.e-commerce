package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.ProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.request.AddProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.request.UpdateProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductListResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.response.ProductPriceChangedResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductListResponse> getAll() {
        List<Product> products = productRepository.findAll();
        return ProductMapper.INSTANCE.productGetAllResponseListFromProductList(products);
    }
    @Override
    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void add(AddProductRequest addProductRequest) {
        Product product=ProductMapper.INSTANCE.productFromAddRequest(addProductRequest);
        productRepository.save(product);
    }

    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        if( productRepository.findById(updateProductRequest.getUpdatedId()).isEmpty()){
            throw new BusinessException("Product not found with id " + updateProductRequest.getUpdatedId());

        }

        Product product=ProductMapper.INSTANCE.productFromUpdateRequest(updateProductRequest);
        productRepository.save(product);

    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductPriceChangedResponse> getProductsWithPriceGoneUp() {
        return productRepository.getProductsWithPriceGoneUp();
    }

    @Override
    public List<ProductPriceChangedResponse> getProductsWithPriceWentDown() {
        return productRepository.getProductsWithPriceWentDown();
    }

    @Override
    public Product findTopByOrderByPriceDesc() {
        return productRepository.findTopByOrderByPriceDesc();
    }


}
