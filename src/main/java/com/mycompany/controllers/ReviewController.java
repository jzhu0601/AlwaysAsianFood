package com.mycompany.controllers;

import com.mycompany.entities.Customer;
import com.mycompany.entities.Restaurant;
import com.mycompany.entities.Review;
import com.mycompany.services.CustomerService;
import com.mycompany.services.CustomerService;
import com.mycompany.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by mantou on 11/20/2015.
 */
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/api/reviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Review>> getCustomers() {

        Collection<Review> reviews = reviewService.findAll();

        return new ResponseEntity<Collection<Review>>(reviews, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/reviews/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> getReview(@PathVariable("id") Integer reviewId) {

        Review review = reviewService.findOne(reviewId);

        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/reviews", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review review1 = reviewService.create(review);
        return new ResponseEntity<Review>(review1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/reviews/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> updateReview(
            @RequestBody Review review) {

        Review review1 = reviewService.update(review);
        if (review1 == null) {
            return new ResponseEntity<Review>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Review>(review1, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/reviews/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Review> deleteReview(@PathVariable("id") Integer id) {
        reviewService.delete(id);
        return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
    }


}
