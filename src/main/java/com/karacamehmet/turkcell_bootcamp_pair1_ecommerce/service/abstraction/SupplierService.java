package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.AddSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.UpdateSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.responses.SupplierListResponse;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierListResponse> getAll();
    Supplier getById(int id);

    void add(AddSupplierRequest addSupplierRequest);

    void update(UpdateSupplierRequest updateSupplierRequest);

    void deleteById(int id);
}
