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
        restaurant.setRestaurantId(2);
        restaurant.setRestaurantName("dfLesfdss's Asian Grill");
        restaurant.setPhoneNum("614-8sdfdf76-9786");
        restaurant.setBusinessHours("Monsfdsf-Fri 11-5");
        restaurant.setRestaurantAddress("123efe Eat lots Ave, Columbus,OH 43212");
        restaurant.setWebsite("www.leefefsgrill.com");

        restaurantDAO.save(restaurant);
        System.out.println(restaurantDAO.count());

    }
}
