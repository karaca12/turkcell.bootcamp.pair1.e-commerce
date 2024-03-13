package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.response.CityGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<CityGetAllResponse> getAll();

    Optional<City> getById(int id);

    void add(CityAddRequest cityAddRequest);

    void update(CityUpdateRequest cityUpdateRequest);

    void deleteById(int id);
}
