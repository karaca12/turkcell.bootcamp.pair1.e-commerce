package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.WishlistsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistsItemRepository extends JpaRepository<WishlistsItem, Integer> {
}
