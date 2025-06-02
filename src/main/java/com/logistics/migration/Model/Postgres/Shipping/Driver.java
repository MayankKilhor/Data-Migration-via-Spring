package com.logistics.migration.Model.Postgres.Shipping;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @Column(name = "driver_id", nullable = false)
    private String driverId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "age",nullable = false)
    private Long age;

    @Column(name = "phone_no")
    private String phoneNo;

    @OneToOne(mappedBy = "driver", fetch = FetchType.LAZY)
    @JsonIgnore
    private ShippingTruck shippingTruck;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = "image_url")
    private String imageUrl;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShippingTruck getShippingTruck() {
        return shippingTruck;
    }

    public void setShippingTruck(ShippingTruck shippingTruck) {
        this.shippingTruck = shippingTruck;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getAge() {
        return age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
