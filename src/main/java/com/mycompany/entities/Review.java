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

//    @Column(name = "review_star")
//    private Integer reviewStar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Restaurant restaurant;

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

//    public Integer getReviewStar() {
//        return reviewStar;
//    }
//
//    public void setReviewStar(Integer reviewStar) {
//        this.reviewStar = reviewStar;
//    }


    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewContent='" + reviewContent + '\'' +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                '}';
    }
}
