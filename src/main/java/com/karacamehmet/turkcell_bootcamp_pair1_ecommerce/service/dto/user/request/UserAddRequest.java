package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
public class UserAddRequest {
    @Length(min = 2)
    private String name;
    private String email;
    @Length(min = 3)
    private String passwordHash;
    private String phoneNumber;
}
