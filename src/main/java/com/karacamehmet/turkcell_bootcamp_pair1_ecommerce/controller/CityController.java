package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cities")
public class CityController {
    private final CityService cityService;

    @GetMapping
    List<City> getAll() {
        return cityService.getAll();
    }
}