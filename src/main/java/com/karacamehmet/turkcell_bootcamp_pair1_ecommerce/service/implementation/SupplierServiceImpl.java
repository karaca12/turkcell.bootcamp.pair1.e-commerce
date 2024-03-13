package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.SupplierRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.SupplierService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.UserService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.AddSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.UpdateSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.responses.SupplierListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    private final UserService userService;
    @Override
    public List<SupplierListResponse> getAll() {
        List<Supplier> suppliers=supplierRepository.findAll();
        List<SupplierListResponse> supplierListResponses=new ArrayList<>();
        for (Supplier i:suppliers){
            User user= userService.getById(i.getId()).orElseThrow(()-> new BusinessException("User not found with id "+i.getId()));
            SupplierListResponse dto=new SupplierListResponse(i.getId(),user.getName(),user.getEmail(),user.getPhoneNumber(),i.getTaxNo(),i.getRating());
            supplierListResponses.add(dto);
        }
        return supplierListResponses;
    }

    @Override
    public Optional<Supplier> getById(int id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void add(AddSupplierRequest addSupplierRequest) {
        User user= userService.getById(addSupplierRequest.getUserId()).orElseThrow(()-> new BusinessException("User not found with id "+addSupplierRequest.getUserId()));
        Supplier supplier=new Supplier();
        supplier.setUsers(user);
        supplier.setRating(addSupplierRequest.getRating());
        supplier.setTaxNo(addSupplierRequest.getTaxNo());

        supplierRepository.save(supplier);
    }

    @Override
    public void update(UpdateSupplierRequest updateSupplierRequest)
    {
        Supplier supplier=supplierRepository.findById(updateSupplierRequest.getUserId()).orElseThrow(()-> new BusinessException("Supplier not found with id "+updateSupplierRequest.getUserId()));
        supplier.setTaxNo(updateSupplierRequest.getTaxNo());
        supplier.setRating(updateSupplierRequest.getRating());
        supplierRepository.save(supplier);

    }

    @Override
    public void deleteById(int id) {
        supplierRepository.deleteById(id);
    }
}
