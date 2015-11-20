package com.mycompany.controllers;

import com.mycompany.entities.Restaurant;
import com.mycompany.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by jzhu on 11/20/2015.
 */
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/api/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Restaurant>> getRestaurants() {

        Collection<Restaurant> greetings = restaurantService.findAll();

        return new ResponseEntity<Collection<Restaurant>>(greetings,
                HttpStatus.OK);
    }

}
