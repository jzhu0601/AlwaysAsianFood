package com.mycompany.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jzhu on 11/17/2015.
 */

@Entity
@Table(name = "reviews")
public class Review implements Serializable {


    @Id
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "review_content")
    private String reviewContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


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

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}
