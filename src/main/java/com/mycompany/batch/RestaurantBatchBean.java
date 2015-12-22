package com.mycompany.batch;

import com.mycompany.entities.Restaurant;
import com.mycompany.services.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Jason on 12/22/15.
 */
@Component
public class RestaurantBatchBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestaurantService restaurantService;

    //Uncomment the line below to start the cronJob
    // @Scheduled(cron = "0,50 * * * * *")
    public void cronJob() {
        logger.info("> cronJob");

        Collection<Restaurant> restaurants = restaurantService.findAll();

        logger.info("There are {} restaurants in the database.", restaurants.size());

        logger.info("< cronJob");
    }
}
