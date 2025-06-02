package com.spaceage.logistics.Payload.Request.BOM;

import jakarta.validation.constraints.NotBlank;

public class BOMRequest {

    private String customerId;

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }
}
