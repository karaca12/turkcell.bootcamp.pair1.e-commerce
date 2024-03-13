package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Country;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.response.CountryGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<CountryGetAllResponse> getAll();

    Optional<Country> getById(int id);

    void add(CountryAddRequest countryAddRequest);

    void update(CountryUpdateRequest countryUpdateRequest);

    void deleteById(int id);

    Long getCountById();
}
