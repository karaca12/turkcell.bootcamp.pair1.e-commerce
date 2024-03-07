package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Adress;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.AdressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/adresses")
public class AdressController {
    private final AdressService adressService;



    @GetMapping
    public List<Adress> getAll() {
        return adressService.getAll();
    }
}
