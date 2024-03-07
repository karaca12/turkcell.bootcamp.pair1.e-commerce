package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CityRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getById(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public void add(City city) {
        cityRepository.save(city);
    }

    @Override
    public void update(City city) {

    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }
}
