package com.mycompany.services;

import com.mycompany.Repositories.ReviewRepository;
import com.mycompany.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by jzhu on 11/17/2015.
 */
@Service
@Transactional
public class ReviewService {
    @Autowired
    private ReviewRepository reviewDAO;


    public List<Review> getReviewsBaseOnRestaurantId(Integer id){
        return reviewDAO.queryByRestaurant(id);
    }

    public List<Review> getReviewsBasedOnCustomerId(Integer id){
        return reviewDAO.queryByCustomer(id);
    }

    public Collection<Review> findAll() {
        return reviewDAO.findAll();
    }

    public Review create(Review review, Integer cusId, Integer restId) {
        Review reviewToCreate = new Review();

        return reviewDAO.save(review);
    }


    public Collection<Review> getReviewsBasedOnCustomerAndRestaurantId(Integer cusId, Integer restId) {
        return reviewDAO.queryByCustomerAndRestaurant(cusId,restId);
    }

}
