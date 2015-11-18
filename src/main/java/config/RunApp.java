package config;

import Repositories.RestaurantDAO;
import entities.Restaurant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jzhu on 11/18/2015.
 */
public class RunApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "jpaContext.xml");

        RestaurantDAO restaurantDAO = context.getBean(RestaurantDAO.class);

        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1);
        restaurant.setRestaurantName("Less's Asian Grill");
        restaurant.setPhoneNum("614-876-9786");
        restaurant.setBusinessHours("Mon-Fri 11-5");
        restaurant.setRestaurantAddress("123 Eat lots Ave, Columbus,OH 43212");
        restaurant.setWebsite("www.leesgrill.com");

        restaurantDAO.save(restaurant);
        System.out.println(restaurantDAO.count());

    }
}
