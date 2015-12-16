package com.mycompany.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jzhu on 11/17/2015.
 */
@Entity
@Table(name = "reviews")
public class Review implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "review_star")
    private String reviewStar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "review")
    private Restaurant restaurant;

    @Transient
    private Integer restaurantId;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewStar() {
        return reviewStar;
    }

    public void setReviewStar(String reviewStar) {
        this.reviewStar = reviewStar;
    }


}
