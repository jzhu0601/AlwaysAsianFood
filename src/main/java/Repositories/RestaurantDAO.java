package Repositories;

import entities.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jzhu on 11/17/2015.
 */
@Repository
public class RestaurantDAO {
    public List<Restaurant> getAllRestaurants() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1);
        restaurant.setRestaurantName("Less's Asian Grill");
        restaurant.setPhoneNum("614-8769-786");
        restaurant.setBusinessHours("Mon-Fri 11-5");
        restaurant.setRestaurantAddress("123 Eat lots Ave, Columbus,OH 43212");
        restaurant.setWebsite("www.leesgrill.com");

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantId(2);
        restaurant1.setRestaurantName("Cool coco Chicke");
        restaurant1.setPhoneNum("614-136-5481");
        restaurant1.setBusinessHours("MonSun 1210");
        restaurant1.setRestaurantAddress("123 So Full Lane, Columbus,OH 43113");
        restaurant1.setWebsite("www.cocochicken.com");

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant);
        restaurants.add(restaurant1);

        return restaurants;
    }
}
