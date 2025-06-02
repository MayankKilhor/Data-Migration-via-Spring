package com.spaceage.logistics.Payload.Request.BOM;

import com.spaceage.logistics.Payload.enums.ShippingLoc;
import jakarta.validation.constraints.NotBlank;

public class ShippingLocRequest {

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    private ShippingLoc shippingLoc;

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public ShippingLoc getShippingLoc() {
        return shippingLoc;
    }

    public void setShippingLoc(ShippingLoc shippingLoc) {
        this.shippingLoc = shippingLoc;
    }
}
