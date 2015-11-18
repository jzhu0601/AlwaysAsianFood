package controllers;

import entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import services.RestaurantService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jzhu on 11/17/2015.
 */
@Controller
@RequestMapping(value = "/services/rest")
public class RestaurantController {

    private RestaurantService restaurantService = new RestaurantService();

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getALLRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
    @ResponseBody
    public Restaurant getRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1);
        restaurant.setRestaurantName("Less's Asian Grill");
        restaurant.setPhoneNum("614-876-9786");
        restaurant.setBusinessHours("Mon-Fri 11-5");
        restaurant.setRestaurantAddress("123 Eat lots Ave, Columbus,OH 43212");
        restaurant.setWebsite("www.leesgrill.com");
        return restaurant;
    }
}
