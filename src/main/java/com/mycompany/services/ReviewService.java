package com.mycompany.services;

import com.mycompany.Repositories.ReviewRepository;
import com.mycompany.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Collection;

/**
 * Created by jzhu on 11/17/2015.
 */
@Service
@Transactional
public class ReviewService {
    @Autowired
    private ReviewRepository reviewDAO;

    public Review saveReview(Review review) {
        return reviewDAO.save(review);
    }

    public Collection<Review> findAll() {
        return reviewDAO.findAll();
    }

    public Review findOne(Integer reviewId) {
        return reviewDAO.findOne(reviewId);
    }

    public Review create(Review review) {
        return reviewDAO.save(review);
    }

    public Review update(Review review) {

        Review reviewToUpdate = findOne(review.getReviewId());

        if (reviewToUpdate == null) {
            throw new NoResultException("Requested review not found.");
        }

        reviewToUpdate.setReviewContent(review.getReviewContent());
        reviewToUpdate.setReviewId(review.getReviewId());
        ;
        return reviewDAO.save(reviewToUpdate);

    }

    public void delete(Integer id) {
        reviewDAO.delete(id);
    }
}
