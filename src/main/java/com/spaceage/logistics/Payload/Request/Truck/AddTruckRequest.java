package com.spaceage.logistics.Payload.Request.Truck;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddTruckRequest {


    @NotBlank(message = "truckId can't be empty!")
     private String truckId;

    @NotBlank(message = "model can't be empty!")
    private String model;

    @NotNull(message = "LinkToDriver can't be empty!")
    private Boolean linkToDriver;

    private String driverId;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getLinkToDriver() {
        return linkToDriver;
    }

    public void setLinkToDriver(Boolean linkToDriver) {
        this.linkToDriver = linkToDriver;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }
}
