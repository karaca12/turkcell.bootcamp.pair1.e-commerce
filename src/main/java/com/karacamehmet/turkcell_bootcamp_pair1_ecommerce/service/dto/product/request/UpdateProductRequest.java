package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.product.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateProductRequest {




    @Min(1)
    private Integer updatedId;

    @NotBlank(message = "Name of a product cannot be empty")
    private String name;
    @NotBlank(message = "Description of a product cannot be empty")
    private String description;
    @Min(value = 0,message = "Price of a product must be minimum 0")
    private double price;
    @Min(value = 0,message = "Stocks of a product must be minimum 0")
    private Integer stock;
    @Min(1)
    private Integer supplierId;
}
