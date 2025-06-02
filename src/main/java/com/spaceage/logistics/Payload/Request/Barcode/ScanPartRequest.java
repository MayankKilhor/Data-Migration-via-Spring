package com.spaceage.logistics.Payload.Request.Barcode;

import jakarta.validation.constraints.NotBlank;

public class ScanPartRequest {

    @NotBlank(message = "partId can't be empty!")
    private String partId;

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    @NotBlank(message = "palletId can't be empty!")
    private String palletId;

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public String getPalletId() {
        return palletId;
    }

    public void setPalletId(String palletId) {
        this.palletId = palletId;
    }
}
