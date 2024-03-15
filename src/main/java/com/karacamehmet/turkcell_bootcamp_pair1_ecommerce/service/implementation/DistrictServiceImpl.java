package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Country;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.DistrictRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.CityService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.DistrictService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request.DistrictAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request.DistrictUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.response.DistrictGetAllResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.DistrictMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final CityService cityService;

    public DistrictServiceImpl(DistrictRepository districtRepository, CityService cityService) {
        this.districtRepository = districtRepository;
        this.cityService = cityService;
    }

    @Override
    public List<DistrictGetAllResponse> getAll() {
        List<District> districts = districtRepository.findAll();
        return DistrictMapper.INSTANCE.districtGetAllResponseListFromDistrictList(districts);
    }

    @Override
    public Optional<District> getById(int id) {
        return districtRepository.findById(id);
    }

    @Override
    public void add(DistrictAddRequest districtAddRequest) {
        cityService.getById(districtAddRequest.getCityId())
                .orElseThrow(() -> new BusinessException("City not found"));

        District district = DistrictMapper.INSTANCE.districtFromAddRequest(districtAddRequest);
        districtRepository.save(district);
    }

    @Override
    public void update(DistrictUpdateRequest districtUpdateRequest) {
        districtRepository.findById(districtUpdateRequest.getUpdatedId())
                .orElseThrow(() -> new BusinessException("District not found"));
        cityService.getById(districtUpdateRequest.getCityId())
                .orElseThrow(() -> new BusinessException("City not found"));

        District district = DistrictMapper.INSTANCE.districtFromUpdateRequest(districtUpdateRequest);
        districtRepository.save(district);
    }

    @Override
    public void deleteById(int id) {
        districtRepository.deleteById(id);
    }
}
