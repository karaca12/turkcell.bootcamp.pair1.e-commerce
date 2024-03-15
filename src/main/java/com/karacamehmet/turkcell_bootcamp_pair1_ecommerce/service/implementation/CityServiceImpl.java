package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Country;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.CityRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CityService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CountryService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.response.CityGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.CityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CountryService countryService;

    public CityServiceImpl(CityRepository cityRepository, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    @Override
    public List<CityGetAllResponse> getAll() {
        List<City> cities = cityRepository.findAll();
        return CityMapper.INSTANCE.cityGetAllResponseListFromCityList(cities);
    }

    @Override
    public Optional<City> getById(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public void add(CityAddRequest cityAddRequest) {
        countryService.getById(cityAddRequest.getCountryId())
                .orElseThrow(() -> new BusinessException("Country not found"));

        City city = CityMapper.INSTANCE.cityFromAddRequest(cityAddRequest);
        cityRepository.save(city);
    }

    @Override
    public void update(CityUpdateRequest cityUpdateRequest) {
        cityRepository.findById(cityUpdateRequest.getUpdatedId())
                .orElseThrow(() -> new BusinessException("City not found"));
        countryService.getById(cityUpdateRequest.getCountryId())
                .orElseThrow(() -> new BusinessException("Country not found"));

        City city = CityMapper.INSTANCE.cityFromUpdateRequest(cityUpdateRequest);
        cityRepository.save(city);
    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }
}
