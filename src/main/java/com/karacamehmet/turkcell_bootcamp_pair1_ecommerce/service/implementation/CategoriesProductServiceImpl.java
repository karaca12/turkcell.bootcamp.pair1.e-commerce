package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.*;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CategoriesProductRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CategoriesProductService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.request.CategoriesProductAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.response.CategoriesProductGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.CategoriesProductMapper;
import org.springframework.stereotype.Service;

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
        return CategoriesProductMapper.INSTANCE.categoriesProductGetAllResponseListFromCategoriesProductList(categoriesProducts);
    }

    @Override
    public Optional<CategoriesProduct> getById(int id) {
        return categoriesProductRepository.findById(id);
    }

    @Override
    public void add(CategoriesProductAddRequest categoriesProductAddRequest) {
        checkIfCategoryAndProductAlreadyConnected(categoriesProductAddRequest.getCategoryId(), categoriesProductAddRequest.getProductId());
        CategoriesProduct categoriesProduct = CategoriesProductMapper.INSTANCE.categoriesProductFromAddRequest(categoriesProductAddRequest);
        categoriesProductRepository.save(categoriesProduct);
    }

    @Override
    public void update(CategoriesProduct categoriesProduct) {

    }

    @Override
    public void deleteById(int id) {
        categoriesProductRepository.deleteById(id);
    }


    private void checkIfCategoryAndProductAlreadyConnected(Integer categoryId, Integer productId) {
        if (categoriesProductRepository.findByCategoryId_IdAndProductId_Id(categoryId, productId).isPresent()) {
            throw new BusinessException("Product and Category already connected");
        }

    }

}