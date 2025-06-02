package com.spaceage.logistics.Model.Postgres.Shipping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spaceage.logistics.Model.Postgres.Pallet;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "shipping_truck")
public class ShippingTruck {

    @Id
    @Column(name = "truck_id", nullable = false)
    private String truckId;

    @Column(name = "model", nullable = false)
    private String model;


    @Column(name = "dry_weight")
    private String dryWeight;

    @Column(name = "wet_weight")
    private String wetWeight;

    @OneToOne(mappedBy = "truckInfo", fetch = FetchType.LAZY)
    @JsonIgnore
    private Pallet pallet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id", foreignKey = @ForeignKey(name = "fk_driver"))
    @JsonBackReference
    private Driver driver;

    @Column(name = "truck_image_url")
    private String truckImageUrl;

    @Column(name = "front_image_url")
    private String frontImageUrl;

    @Column(name = "side_image_url")
    private String sideImageUrl;

    @Column(name = "back_image_url")
    private String backImageUrl;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getDryWeight() {
        return dryWeight;
    }

    public void setDryWeight(String dryWeight) {
        this.dryWeight = dryWeight;
    }

    public String getWetWeight() {
        return wetWeight;
    }

    public void setWetWeight(String wetWeight) {
        this.wetWeight = wetWeight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTruckImageUrl() {
        return truckImageUrl;
    }

    public void setTruckImageUrl(String truckImageUrl) {
        this.truckImageUrl = truckImageUrl;
    }

    public String getFrontImageUrl() {
        return frontImageUrl;
    }

    public void setFrontImageUrl(String frontImageUrl) {
        this.frontImageUrl = frontImageUrl;
    }

    public String getSideImageUrl() {
        return sideImageUrl;
    }

    public void setSideImageUrl(String sideImageUrl) {
        this.sideImageUrl = sideImageUrl;
    }

    public String getBackImageUrl() {
        return backImageUrl;
    }

    public void setBackImageUrl(String backImageUrl) {
        this.backImageUrl = backImageUrl;
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
}
