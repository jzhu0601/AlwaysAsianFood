package com.mycompany.controllers;

import com.mycompany.entities.Review;
import com.mycompany.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by mantou on 11/20/2015.
 */
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /*
    This method returns all the reviews from the review table
     */
    @RequestMapping(value = "/api/reviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Review>> getAllReviews() {
        Collection<Review> reviews = reviewService.findAll();
        return new ResponseEntity<Collection<Review>>(reviews, HttpStatus.OK);
    }

    /*
    This method returns reviews based on the restaurantId
     */
    @RequestMapping(value = "/api/reviews/{restaurantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Review>> getReviewsBaseOnRestaurantId(@PathVariable("restaurantId") Integer id) {
        Collection<Review> reviews = reviewService.getReviewsBaseOnRestaurantId(id);
        return new ResponseEntity<Collection<Review>>(reviews, HttpStatus.OK);
    }

    /*
    This method returns reviews based on the customerId
    */
    @RequestMapping(value = "/api/{customerId}/reviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Review>> getReviewsBaseCustomerId(@PathVariable("customerId") Integer id) {
        Collection<Review> reviews = reviewService.getReviewsBasedOnCustomerId(id);
        return new ResponseEntity<Collection<Review>>(reviews, HttpStatus.OK);
    }

    /*
    This method returns reviews based on the customerId and restaurantId
    */
    @RequestMapping(value = "/api/reviews/{customerId}/{restaurantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Review>> getReviewsBaseCustomerIdAndRestaurantId(@PathVariable("customerId") Integer cusId, @PathVariable("restaurantId") Integer restId) {
        Collection<Review> reviews = reviewService.getReviewsBasedOnCustomerAndRestaurantId(cusId,restId);
        return new ResponseEntity<Collection<Review>>(reviews, HttpStatus.OK);
    }

    /*
    This method post reviews based on customer and restaurant Id
     */
//    @RequestMapping(value = "/api/reviews/{customerId}/{restaurantId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Review> createReview(@RequestBody Review review, @PathVariable("customerId") Integer cusId, @PathVariable("restaurantId") Integer restId) {
//
//        Review review1 = reviewService.create(review, cusId, restId);
//
//        return new ResponseEntity<Review>(review1, HttpStatus.OK);
//    }

}
