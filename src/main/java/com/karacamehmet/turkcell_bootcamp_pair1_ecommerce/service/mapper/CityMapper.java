package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.City;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.request.CityUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.city.response.CityGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(source = "countryId.id", target = "countryId")
    CityGetAllResponse cityGetAllResponseFromCity(City city);

    List<CityGetAllResponse> cityGetAllResponseListFromCityList(List<City> cities);

    @Mapping(source = "countryId", target = "countryId.id")
    City cityFromAddRequest(CityAddRequest cityAddRequest);

    @Mapping(source = "updatedId", target = "id")
    @Mapping(source = "countryId", target = "countryId.id")
    City cityFromUpdateRequest(CityUpdateRequest cityUpdateRequest);
}
