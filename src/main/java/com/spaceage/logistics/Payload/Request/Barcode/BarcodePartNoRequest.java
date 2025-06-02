package com.spaceage.logistics.Payload.Request.Barcode;

import jakarta.validation.constraints.NotBlank;

public class BarcodePartNoRequest {

    @NotBlank(message = "partNo can't be empty!")
    private String partNo;

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

}
