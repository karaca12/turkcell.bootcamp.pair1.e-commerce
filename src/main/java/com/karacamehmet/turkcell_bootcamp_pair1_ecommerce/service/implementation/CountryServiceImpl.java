package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Country;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CountryRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CountryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.response.CountryGetAllResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryGetAllResponse> getAll() {
        return countryRepository.findAll().stream()
                .map(country -> {
                    return CountryGetAllResponse.builder()
                            .name(country.getName())
                            .id(country.getId())
                            .build();
                }).toList();
    }

    @Override
    public Optional<Country> getById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public void add(CountryAddRequest countryAddRequest) {
        Country country = new Country();
        country.setName(countryAddRequest.getName());

        countryRepository.save(country);
    }

    @Override
    public void update(CountryUpdateRequest countryUpdateRequest) {
        Country country = getById(countryUpdateRequest.getUpdatedId())
                .orElseThrow(() -> new BusinessException("Country not found"));
        country.setName(countryUpdateRequest.getName());

        countryRepository.save(country);
    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Long getCountById() {
        return countryRepository.count();
    }
}
