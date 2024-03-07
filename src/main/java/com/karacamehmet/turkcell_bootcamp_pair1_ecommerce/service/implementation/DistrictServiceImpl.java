package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.DistrictRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.DistrictService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<District> getAll() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> getById(int id) {
        return districtRepository.findById(id);
    }

    @Override
    public void add(District district) {
        districtRepository.save(district);
    }

    @Override
    public void update(District district) {

    }

    @Override
    public void deleteById(int id) {
        districtRepository.deleteById(id);
    }
}
