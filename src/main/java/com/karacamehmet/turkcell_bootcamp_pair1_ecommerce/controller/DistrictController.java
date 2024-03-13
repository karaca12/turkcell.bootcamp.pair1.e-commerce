package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.DistrictService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request.DistrictAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request.DistrictUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.response.DistrictGetAllResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/districts")
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping
    public List<DistrictGetAllResponse> getAll() {
        return districtService.getAll();
    }

    @PostMapping
    void createDistrict(@RequestBody @Valid DistrictAddRequest districtAddRequest) {
        districtService.add(districtAddRequest);
    }

    @PutMapping
    void updateDistrict(@RequestBody @Valid DistrictUpdateRequest districtUpdateRequest) {
        districtService.update(districtUpdateRequest);
    }
}
