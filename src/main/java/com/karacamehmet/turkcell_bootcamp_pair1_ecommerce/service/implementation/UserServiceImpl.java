package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.UserRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.UserService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.request.UserAddRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.response.UserAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User add(UserAddRequest userAddRequest) {
        if (userWithSameEmailExists(userAddRequest.getEmail())) {
            throw new BusinessException("This email is already in use.");
        }

        User newUser = new User();
        newUser.setName(userAddRequest.getName());
        newUser.setEmail(userAddRequest.getEmail());
        newUser.setPasswordHash(userAddRequest.getPasswordHash());
        newUser.setPhoneNumber(userAddRequest.getPhoneNumber());
        return userRepository.save(newUser);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserAddressResponse getUserAddress(int id) {
        return userRepository.getUserAddress(id);
    }

    @Override
    public int countByCustomerNotNull() {
        return userRepository.countByCustomerNotNull();
    }
    public int countBySupplierNotNull(){
        return userRepository.countBySupplierNotNull();
    }

    @Override
    public boolean userWithSameEmailExists(String email) {
        Optional<User> userWithSameEmail = userRepository.findByEmail(email);
        return userWithSameEmail.isPresent();
    }
}
