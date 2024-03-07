package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> getAll();

    Optional<City> getById(int id);

    void add(City city);

    void update(City city);

    void deleteById(int id);
}
