package com.mycompany.controllers;

import com.mycompany.entities.Customer;
import com.mycompany.entities.Restaurant;
import com.mycompany.services.CustomerService;
import com.mycompany.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by jzhu on 11/20/2015.
 */
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    private CustomerService customerService;

    @RequestMapping(value = "/api/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Restaurant>> getRestaurants() {

        Collection<Restaurant> restaurants = restaurantService.findAll();

        return new ResponseEntity<Collection<Restaurant>>(restaurants, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/restaurants/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Integer restaurantId) {

        Restaurant restaurant = restaurantService.findOne(restaurantId);

        return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/restaurants", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant restaurant1 = restaurantService.create(restaurant);
        return new ResponseEntity<Restaurant>(restaurant1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/restaurants/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody Restaurant restaurant) {

        Restaurant restaurant1 = restaurantService.update(restaurant);
        if (restaurant1 == null) {
            return new ResponseEntity<Restaurant>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Restaurant>(restaurant1, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/restaurants/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable("id") Integer id) {
        restaurantService.delete(id);
        return new ResponseEntity<Restaurant>(HttpStatus.NO_CONTENT);
    }


}
