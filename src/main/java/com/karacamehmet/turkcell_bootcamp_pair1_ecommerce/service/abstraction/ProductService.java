package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
}
