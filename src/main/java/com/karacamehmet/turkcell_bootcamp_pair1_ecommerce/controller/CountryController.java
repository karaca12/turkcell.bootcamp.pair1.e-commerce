package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CountryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.response.CountryGetAllResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    List<CountryGetAllResponse> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/count")
    Long getCountById() {
        return countryService.getCountById();
    }

    @PostMapping
    void createCountry(@RequestBody @Valid CountryAddRequest countryAddRequest) {
        countryService.add(countryAddRequest);
    }

    @PutMapping
    void updateCountry(@RequestBody @Valid CountryUpdateRequest countryUpdateRequest) {
        countryService.update(countryUpdateRequest);
    }
}