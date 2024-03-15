package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Supplier;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.SupplierService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.AddSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.requests.UpdateSupplierRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.supplier.responses.SupplierListResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@AllArgsConstructor
public class SupplierController {
    private SupplierService supplierService;
    @GetMapping("/getAll")
    List<SupplierListResponse> getAll(){
        return supplierService.getAll();
    }
    @PostMapping("/addSupplier")
    public void add(@RequestBody AddSupplierRequest addSupplierRequest){
        supplierService.add(addSupplierRequest);

    }
    @PutMapping("/updateSupplier")
    public void update(@RequestBody UpdateSupplierRequest updateSupplierRequest){
        supplierService.update(updateSupplierRequest);

    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        supplierService.deleteById(id);
    }
}
