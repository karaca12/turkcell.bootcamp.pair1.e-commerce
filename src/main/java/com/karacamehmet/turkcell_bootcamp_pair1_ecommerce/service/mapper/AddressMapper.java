package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.request.AddressUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.address.response.AddressGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "districtId", target = "districtId.id")
    @Mapping(source = "userId", target = "userId.id")
    Address addressFromAddRequest(AddressAddRequest addressAddRequest);

    @Mapping(source = "districtId.id", target = "districtId")
    @Mapping(source = "userId.id", target = "userId")
    AddressGetAllResponse addressGetAllResponseFromAddress(Address address);

    List<AddressGetAllResponse> addressGetAllResponseListFromAddressList(List<Address> addresses);

    @Mapping(source = "updatedId", target = "id")
    @Mapping(source = "districtId", target = "districtId.id")
    @Mapping(source = "userId", target = "userId.id")
    Address addressFromUpdateRequest(AddressUpdateRequest addressUpdateRequest);
}
