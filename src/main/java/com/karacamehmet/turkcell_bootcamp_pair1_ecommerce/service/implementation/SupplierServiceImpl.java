package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.SupplierRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> getById(int id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void add(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void update(Supplier supplier) {

    }

    @Override
    public void deleteById(int id) {
        supplierRepository.deleteById(id);
    }
}
