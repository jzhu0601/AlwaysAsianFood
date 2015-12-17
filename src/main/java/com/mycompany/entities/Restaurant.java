package com.mycompany.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jzhu on 11/17/2015.
 */

@Entity
@Table(name = "restaurants")
public class Restaurant implements Serializable {

    @Id
    @Column(name = "restaurant_id")
    @GeneratedValue
    private Integer restaurantId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "address")
    private String restaurantAddress;

    @Column(name = "phone")
    private String phoneNum;

    @Column(name = "website")
    private String website;

    @Column(name = "business_hour")
    private String businessHours;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference(value="review")
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference(value="api")
    @JsonIgnore
    private Set<ApiLink> apiLinks = new HashSet<>();

    public Restaurant(){

    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<ApiLink> getApiLinks() {
        return apiLinks;
    }

    public void setApiLinks(Set<ApiLink> apiLinks) {
        this.apiLinks = apiLinks;
    }

}
