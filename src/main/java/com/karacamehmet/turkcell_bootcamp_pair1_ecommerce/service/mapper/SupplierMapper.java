package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.AddSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.UpdateSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.responses.SupplierListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);


    @Mapping(target = "users", ignore = true)
    Supplier supplierFromAddRequest(AddSupplierRequest addSupplierRequest);

    @Mapping(source = "users.name", target = "name")
    @Mapping(source = "users.email", target = "email")
    @Mapping(source = "users.phoneNumber", target = "phoneNumber")
    SupplierListResponse supplierGetAllResponseFromSupplier(Supplier supplier);


    List<SupplierListResponse> supplierGetAllResponseListFromSupplierList(List<Supplier> suppliers);

    @Mapping(source = "userId", target = "id")
    Supplier supplierFromUpdateRequest(UpdateSupplierRequest updateSupplierRequest);



}
