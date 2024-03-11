package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistNonUpdatedResponse {
    private int id;
    private int customerId;
    private String customerName;
    private String customerLasName;
}
