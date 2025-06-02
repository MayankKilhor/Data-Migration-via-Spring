package com.spaceage.logistics.Payload.Request.Truck;

import jakarta.validation.constraints.NotBlank;

public class DriverIdRequest {

    @NotBlank(message = "DriverId can't be empty!")
    private String driverId;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}
