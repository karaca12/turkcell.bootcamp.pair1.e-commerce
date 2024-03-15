package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Shipment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.SupplierRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.SupplierService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.UserService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.AddSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.UpdateSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.responses.SupplierListResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.SupplierMapper;
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

        return SupplierMapper.INSTANCE.supplierGetAllResponseListFromSupplierList(suppliers);
    }

    @Override
    public Supplier getById(int id) {

        return supplierRepository.findById(id).orElseThrow(()->new BusinessException("There is no supplier with id:"+id));
    }

    @Override
    public void add(AddSupplierRequest addSupplierRequest) {
        User user= userService.getById(addSupplierRequest.getUserId()).orElseThrow(()-> new BusinessException("User not found with id "+addSupplierRequest.getUserId()));
        Supplier supplier=SupplierMapper.INSTANCE.supplierFromAddRequest(addSupplierRequest);
        supplier.setUsers(user);


        supplierRepository.save(supplier);
    }

    @Override
    public void update(UpdateSupplierRequest updateSupplierRequest)
    {
        Supplier supplier=SupplierMapper.INSTANCE.supplierFromUpdateRequest(updateSupplierRequest);
        supplierRepository.save(supplier);

    }

    @Override
    public void deleteById(int id) {

        if( supplierRepository.findById(id).isEmpty()){
            throw new BusinessException("Product not found with id " + id);

        }
        supplierRepository.deleteById(id);
    }
}
