package com.mycompany.Repositories;

import com.mycompany.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jzhu on 11/17/2015.
 */
@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Integer> {

}
