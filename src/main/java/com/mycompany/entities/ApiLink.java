package com.mycompany.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jzhu on 11/21/2015.
 */
@Entity
@Table(name = "api_link")
public class ApiLink implements Serializable {

    @Id
    @Column(name = "api_id")
    @GeneratedValue
    private Integer apiId;

    @Column(name = "service_id")
    private Integer serivceId;

    @Column(name = "service_name")
    private String serviceName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Restaurant restaurant;

    @Transient
    private Integer restaurantId;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public Integer getSerivceId() {
        return serivceId;
    }

    public void setSerivceId(Integer serivceId) {
        this.serivceId = serivceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

}
