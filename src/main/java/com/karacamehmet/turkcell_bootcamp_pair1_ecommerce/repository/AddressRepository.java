package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Address;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.District;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Transactional
    @Modifying
    @Query("update Address a set a.details = ?1 where a.id = ?2 and a.districtId = ?3 and a.userId = ?4")
    void updateDetailsByIdAndDistrictIdAndUserId(String details, Integer id, District districtId, User userId);
}