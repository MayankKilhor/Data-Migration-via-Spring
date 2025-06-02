package com.spaceage.logistics.Payload.Request.Truck;

import jakarta.validation.constraints.NotBlank;

public class LinkDriverAndTruckRequest {

    @NotBlank(message = "truckId can't be empty!")
    private String truckId;

    @NotBlank(message = "driverId can't be empty!")
    private String driverId;

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
