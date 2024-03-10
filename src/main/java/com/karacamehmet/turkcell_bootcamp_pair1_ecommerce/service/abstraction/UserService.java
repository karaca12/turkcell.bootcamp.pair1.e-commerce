package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.response.UserAddressResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> getById(int id);

    void add(User user);

    void update(User user);

    void deleteById(int id);
    UserAddressResponse getUserAddress(int id);
    int countByCustomerNotNull();
   int countBySupplierNotNull();
}
