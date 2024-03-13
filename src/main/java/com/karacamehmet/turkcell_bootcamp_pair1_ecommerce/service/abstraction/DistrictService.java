package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request.DistrictAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request.DistrictUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.response.DistrictGetAllResponse;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    List<DistrictGetAllResponse> getAll();

    Optional<District> getById(int id);

    void add(DistrictAddRequest districtAddRequest);

    void update(DistrictUpdateRequest districtUpdateRequest);

    void deleteById(int id);
}
