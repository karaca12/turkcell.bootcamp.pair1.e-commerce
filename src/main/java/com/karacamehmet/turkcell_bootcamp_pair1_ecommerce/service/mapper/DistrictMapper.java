package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request.DistrictAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.request.DistrictUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.district.response.DistrictGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    @Mapping(source = "cityId.id", target = "cityId")
    DistrictGetAllResponse districtGetAllResponseFromDistrict(District district);

    List<DistrictGetAllResponse> districtGetAllResponseListFromDistrictList(List<District> districts);

    @Mapping(source = "cityId", target = "cityId.id")
    District districtFromAddRequest(DistrictAddRequest districtAddRequest);

    @Mapping(source = "updatedId", target = "id")
    @Mapping(source = "cityId", target = "cityId.id")
    District districtFromUpdateRequest(DistrictUpdateRequest districtUpdateRequest);
}
