package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAll();

    Optional<Country> getById(int id);

    void add(Country country);

    void update(Country country);

    void deleteById(int id);
}
