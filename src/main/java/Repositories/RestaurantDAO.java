package Repositories;

import entities.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jzhu on 11/17/2015.
 */
@Repository
public interface RestaurantDAO extends CrudRepository<Restaurant, Integer> {

}
