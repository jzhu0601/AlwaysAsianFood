package com.mycompany.Repositories;

import com.mycompany.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by jzhu on 11/17/2015.
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("From Restaurant as r where r.restaurantName = :restaurantName ")
    Restaurant findRestaurantByName(@Param("restaurantName") String restaurantName);
}

