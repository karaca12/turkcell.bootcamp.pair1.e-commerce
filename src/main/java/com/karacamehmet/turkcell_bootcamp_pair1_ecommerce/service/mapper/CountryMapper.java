package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Country;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.request.CountryUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.country.response.CountryGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryGetAllResponse countryGetAllResponseFromCountry(Country country);

    List<CountryGetAllResponse> countryGetAllResponseListFromCountryList(List<Country> countries);

    Country countryFromAddRequest(CountryAddRequest countryAddRequest);

    @Mapping(source = "updatedId", target = "id")
    Country countryFromUpdateRequest(CountryUpdateRequest countryUpdateRequest);
}
