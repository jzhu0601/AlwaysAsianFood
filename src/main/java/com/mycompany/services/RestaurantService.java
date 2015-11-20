package com.mycompany.services;

import com.mycompany.Repositories.RestaurantDAO;
import com.mycompany.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by jzhu on 11/17/2015.
 */
@Service
@Transactional
public class RestaurantService {
    @Autowired
    private RestaurantDAO restaurantDAO;

    public Restaurant saveResaurant(Restaurant restaurant) {
        return restaurantDAO.save(restaurant);
    }

    public Collection<Restaurant> findAll() {
        return restaurantDAO.findAll();
    }
}
