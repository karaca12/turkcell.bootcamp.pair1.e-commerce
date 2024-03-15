package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.registration.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRegistrationRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String lastName;
}
