package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;


import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
}
