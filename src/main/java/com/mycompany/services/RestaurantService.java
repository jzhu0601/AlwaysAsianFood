package com.mycompany.services;

import com.mycompany.Repositories.RestaurantRepository;
import com.mycompany.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Collection;

/**
 * Created by jzhu on 11/17/2015.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantDAO;

    public Collection<Restaurant> findAll() {
        return restaurantDAO.findAll();
    }

    @Cacheable(value = "restaurants", key = "#restaurantId")
    public Restaurant findOne(Integer restaurantId) {
        return restaurantDAO.findOne(restaurantId);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "restaurants", key = "#result.restaurantId")
    public Restaurant create(Restaurant restaurant) {
        if (restaurant.getRestaurantId() != null) {
            // cannot create restaurant with specified id value
            return null;
        }
        return restaurantDAO.save(restaurant);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "restaurants", key = "#restaurant.restaurantId")
    public Restaurant update(Restaurant restaurant) {

        Restaurant restaruantToUpdate = findOne(restaurant.getRestaurantId());

        if (restaruantToUpdate == null) {
            throw new NoResultException("Requested entity not found.");
        }

        return restaurantDAO.save(restaurant);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CacheEvict(value = "restaurants", key = "#id")
    public void delete(Integer id) {
        restaurantDAO.delete(id);
    }

    @CachePut(value = "restaurants", key = "#restaurantName")
    public Restaurant findByName(String restaurantName) {
        return restaurantDAO.findRestaurantByName(restaurantName);
    }


    @CacheEvict(value = "restaurants", allEntries = true)
    public void evictCache() {

    }
}
