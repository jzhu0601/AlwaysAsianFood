package controllers;

import entities.Restaurant;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.RestaurantService;

/**
 * Created by jzhu on 11/17/2015.
 */
@Controller
@RequestMapping(value = "/services/rest")
public class RestaurantController {

    private RestaurantService restaurantService = new RestaurantService();


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


    @RequestMapping(headers = "Content-Type=application/json", value = "/restaurant", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Restaurant saveRestaurant(@RequestBody String restaurantData) {
        JSONObject jsonObj = new JSONObject(restaurantData);
        Integer restaurantId = (Integer) jsonObj.get("restaurantId");
        String restaurantName = (String) jsonObj.get("restaurantName");
        String restaurantAddress = (String) jsonObj.get("restaurantAddress");
        String phoneNum = (String) jsonObj.get("phoneNum");
        String website = (String) jsonObj.get("website");
        String businessHours = (String) jsonObj.get("businessHours");
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantId);
        restaurant.setRestaurantName(restaurantName);
        restaurant.setPhoneNum(phoneNum);
        restaurant.setBusinessHours(businessHours);
        restaurant.setRestaurantAddress(restaurantAddress);
        restaurant.setWebsite(website);

        return restaurant;
    }
}

