package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by jzhu on 11/17/2015.
 */

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant implements Serializable {

    @Id
    @Column(name = "RESTAURANT_ID")
    private Integer restaurantId;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @Column(name = "ADDRESS")
    private String restaurantAddress;

    @Column(name = "PHONE")
    private String phoneNum;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "BUSINESS_HOUR")
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
