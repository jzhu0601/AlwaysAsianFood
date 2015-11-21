package com.mycompany.entities;

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
    private Integer apiId;

    @Column(name = "service_id")
    private Integer serivceId;

    @Column(name = "service_name")
    private String serviceName;

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

    @Override
    public String toString() {
        return "ApiLink{" +
                "apiId=" + apiId +
                ", serivceId=" + serivceId +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
