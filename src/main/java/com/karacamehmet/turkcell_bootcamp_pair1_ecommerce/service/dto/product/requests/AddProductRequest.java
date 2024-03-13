package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.requests;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    //TODO move to constants and add multi lanuage
    @NotBlank(message="This field cannot be empty")
    @Size(min=3,max=25,message = "This field should contain at least 3 and at most 25 characters. ")
    private String name;
    @Min(value = 0,message = "The price of a product cannot be smaller than 0")
    private double price;
    @Min(0)
    private int stock;

}
