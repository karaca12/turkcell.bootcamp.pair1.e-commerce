package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> getAll();
    Optional<Supplier> getById(int id);

    void add(Supplier supplier);

    void update(Supplier supplier);

    void deleteById(int id);
}
