package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Country;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CountryRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CountryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.response.CountryGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.CountryMapper;
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
        List<Country> countries = countryRepository.findAll();
        return CountryMapper.INSTANCE.countryGetAllResponseListFromCountryList(countries);
    }

    @Override
    public Optional<Country> getById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public void add(CountryAddRequest countryAddRequest) {
        Country country = CountryMapper.INSTANCE.countryFromAddRequest(countryAddRequest);
        countryRepository.save(country);
    }

    @Override
    public void update(CountryUpdateRequest countryUpdateRequest) {
        countryRepository.findById(countryUpdateRequest.getUpdatedId())
                .orElseThrow(() -> new BusinessException("Country not found"));

        Country country = CountryMapper.INSTANCE.countryFromUpdateRequest(countryUpdateRequest);
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
