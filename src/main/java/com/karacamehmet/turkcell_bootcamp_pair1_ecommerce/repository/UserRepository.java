package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.User;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.response.UserAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT new com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.user.response.UserAddressResponse" +
            "(u.name,a.details,d.name,c.name,co.name) from User u join u.addressId a join a.districtId d join d.cityId c join c.countryId co where u.id = :id")
    UserAddressResponse getUserAddress(int id);
    int countByCustomerNotNull();

    int countBySupplierNotNull();



}