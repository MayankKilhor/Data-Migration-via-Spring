package com.spaceage.logistics.Payload.Request.Truck;

import jakarta.validation.constraints.NotBlank;

public class TruckIdRequest {

    @NotBlank(message ="TruckId can't be empty!")
    private String truckId;

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }
}
