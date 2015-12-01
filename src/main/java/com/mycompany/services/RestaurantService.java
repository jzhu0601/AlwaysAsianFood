package com.mycompany.services;

import com.mycompany.Repositories.RestaurantRepository;
import com.mycompany.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Collection;

/**
 * Created by jzhu on 11/17/2015.
 */
@Service
@Transactional
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantDAO;

    public Collection<Restaurant> findAll() {
        return restaurantDAO.findAll();
    }

    public Restaurant findOne(Integer restaurantId) {
        return restaurantDAO.findOne(restaurantId);
    }

    public Restaurant create(Restaurant restaurant) {

        return restaurantDAO.save(restaurant);
    }

    public Restaurant update(Restaurant restaurant) {

        Restaurant restaruantToUpdate = findOne(restaurant.getRestaurantId());

        if (restaruantToUpdate == null) {
            throw new NoResultException("Requested entity not found.");
        }
        restaruantToUpdate.setBusinessHours(restaurant.getBusinessHours());
        restaruantToUpdate.setPhoneNum(restaurant.getPhoneNum());
        restaruantToUpdate.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaruantToUpdate.setRestaurantName(restaurant.getRestaurantName());
        restaruantToUpdate.setWebsite(restaurant.getWebsite());
        return restaurantDAO.save(restaruantToUpdate);

    }

    public void delete(Integer id) {
        restaurantDAO.delete(id);
    }
}
