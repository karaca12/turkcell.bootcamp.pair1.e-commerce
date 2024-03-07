package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Country;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CountryRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CountryService;

import java.util.List;
import java.util.Optional;

public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public void add(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }
}
