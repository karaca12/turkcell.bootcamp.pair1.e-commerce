package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    List<District> getAll();

    Optional<District> getById(int id);

    void add(District district);

    void update(District district);

    void deleteById(int id);
}
