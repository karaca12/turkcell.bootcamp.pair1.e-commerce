package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.ProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.UserService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.requests.AddProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.requests.UpdateProductRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.responses.ProductListResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.responses.ProductPriceChangedResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<ProductListResponse> response = new ArrayList<>();

        // Beginner Level List Mapping
        for (Product product: products) {
            ProductListResponse dto = new ProductListResponse(
                    product.getId(),
                    product.getName(),
                    productRepository.findCategoryIdsByProductId(product.getId()),
                    product.getPrice());
            response.add(dto);
        }

        return response;
    }
    @Override
    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void add(AddProductRequest addProductRequest) {
        Product product=new Product();
        product.setName(addProductRequest.getName());
        product.setPrice(addProductRequest.getPrice());
        product.setStockQuantity(addProductRequest.getStock());
        productRepository.save(product);
    }

    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(updateProductRequest.getUpdatedId())
                .orElseThrow(() -> new BusinessException("Product not found with id " + updateProductRequest.getUpdatedId()));
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product.setDescription(updateProductRequest.getDescription());
        product.setStockQuantity(updateProductRequest.getStock());
        product.setSupplierId(findTopByOrderByPriceDesc().getSupplierId());
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
