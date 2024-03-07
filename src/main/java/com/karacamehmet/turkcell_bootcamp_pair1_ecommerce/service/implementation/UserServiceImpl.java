package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.UserRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
