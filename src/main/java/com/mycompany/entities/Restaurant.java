package com.mycompany.entities;

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

    @OneToMany(mappedBy = "restaurant")
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy="restaurant")
    private Set<ApiLink> apiLinks;

    public Set<ApiLink> getApiLinks() {
        return apiLinks;
    }

    public void setApiLinks(Set<ApiLink> apiLinks) {
        this.apiLinks = apiLinks;
    }

    Restaurant() {

    }

    @Id
    @Column(name = "restaurant_id")
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", website='" + website + '\'' +
                ", businessHours='" + businessHours + '\'' +
                '}';
    }


}
