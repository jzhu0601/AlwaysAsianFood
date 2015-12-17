package com.mycompany.Repositories;

import com.mycompany.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mantou on 11/21/2015.
 */

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("From Review as r where r.restaurant.restaurantId=:id")
    List<Review> queryByRestaurant(@Param("id") Integer id);

    @Query("From Review as r where r.customer.customerId=:id")
    List<Review> queryByCustomer(@Param("id") Integer id);

    @Query("From Review as r where r.customer.customerId=:cusId and r.restaurant.restaurantId=:restId")
    List<Review> queryByCustomerAndRestaurant(@Param("cusId") Integer cusId, @Param("restId") Integer restId);
}