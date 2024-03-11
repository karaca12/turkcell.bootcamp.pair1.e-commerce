package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.categoriesproduct.response;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Category;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesProductGetAllResponse {
    private Integer id;
    private Integer categoryId;
    private Integer productId;
}
