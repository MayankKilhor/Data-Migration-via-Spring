package com.spaceage.logistics.Payload.Request.BOM;

import jakarta.validation.constraints.NotBlank;

public class UserIdRequest {



    @NotBlank(message = "customerId can't be empty!")
    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}
