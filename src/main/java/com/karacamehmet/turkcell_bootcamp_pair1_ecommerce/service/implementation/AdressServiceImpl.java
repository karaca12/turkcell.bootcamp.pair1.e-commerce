package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Adress;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.AdressRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.AdressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdressServiceImpl implements AdressService {
    private AdressRepository adressRepository;
    @Override
    public List<Adress> getAll() {
        return adressRepository.findAll();
    }
}
