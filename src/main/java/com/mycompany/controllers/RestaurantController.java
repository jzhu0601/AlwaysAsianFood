package com.mycompany.controllers;

import com.mycompany.entities.Restaurant;
import com.mycompany.services.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/api/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Restaurant>> getRestaurants() {
        logger.info("> getRestaurants");
        Collection<Restaurant> restaurants = restaurantService.findAll();
        logger.info("< getRestaurants");
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }


//    @RequestMapping(value = "/api/restaurants/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Integer restaurantId) {
//
//        logger.info("> getRestaurants id:{}", restaurantId);
//        Restaurant restaurant = restaurantService.findOne(restaurantId);
//
//        logger.info("< getRestaurants id:{}", restaurantId);
//        return new ResponseEntity<>(restaurant, HttpStatus.OK);
//    }

    @RequestMapping(value = "/api/restaurants/{restaurantName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> getRestaurantByName(@PathVariable("restaurantName") String restaurantName) {

        logger.info("> getRestaurant restaurantName:{}", restaurantName);
        Restaurant restaurant = restaurantService.findByName(restaurantName);
        logger.info("< getRestaurant restaurantName:{}", restaurantName);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/restaurants", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        logger.info("> createRestaurant");
        Restaurant restaurant1 = restaurantService.create(restaurant);
        logger.info("< createRestaurant");
        return new ResponseEntity<>(restaurant1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/restaurants/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody Restaurant restaurant) {
        logger.info("> updateRestaurant id:{}", restaurant.getRestaurantId());
        Restaurant restaurant1 = restaurantService.update(restaurant);
        if (restaurant1 == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        logger.info("< updateRestaurant id:{}", restaurant.getRestaurantId());
        return new ResponseEntity<>(restaurant1, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/restaurants/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable("id") Integer id) {
        logger.info("> deleterestaurant id:{}", id);
        restaurantService.delete(id);
        logger.info("< deleterestaurant id:{}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
