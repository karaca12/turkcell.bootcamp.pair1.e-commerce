package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.registration.request;

import lombok.Getter;

@Getter
public class SupplierRegistrationRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String taxNo;
    private Float rating;

}
