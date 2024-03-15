package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Customer;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.request.CustomerUpdateRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.customer.response.CustomerGetAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerGetAllResponse customerGetAllResponseFromCustomer(Customer customer);

    List<CustomerGetAllResponse> customerGetAllResponseListFromCustomerList(List<Customer> customers);

    Customer customerFromAddRequest(CustomerAddRequest customerAddRequest);

    @Mapping(source = "updatedId", target = "id")
    Customer customerFromUpdateRequest(CustomerUpdateRequest customerUpdateRequest);
}
