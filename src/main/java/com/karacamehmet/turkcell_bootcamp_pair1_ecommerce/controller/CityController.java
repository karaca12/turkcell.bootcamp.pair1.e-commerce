package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CityService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.response.CityGetAllResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cities")
public class CityController {
    private final CityService cityService;

    @GetMapping
    List<CityGetAllResponse> getAll() {
        return cityService.getAll();
    }

    @PostMapping
    void createCity(@RequestBody @Valid CityAddRequest cityAddRequest) {
        cityService.add(cityAddRequest);
    }

    @PutMapping
    void updateCity(@RequestBody @Valid CityUpdateRequest cityUpdateRequest) {
        cityService.update(cityUpdateRequest);
    }
}