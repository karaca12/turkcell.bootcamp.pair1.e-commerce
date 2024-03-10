package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.WishlistsItem;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.response.ProductsAddedToWishlistResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistsItemRepository extends JpaRepository<WishlistsItem, Integer> {
    @Query(value = "select new com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlistsItem.response.ProductsAddedToWishlistResponse" +
            "(wi.productId.id, sum(wi.quantity)) from WishlistsItem wi group by wi.productId")
    List<ProductsAddedToWishlistResponse> howManyAdded();
}
