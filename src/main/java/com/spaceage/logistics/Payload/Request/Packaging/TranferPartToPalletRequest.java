package com.spaceage.logistics.Payload.Request.Packaging;

import jakarta.validation.constraints.NotBlank;

public class TranferPartToPalletRequest {

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    @NotBlank(message = "bomPartId can't be empty!")
    private String bomPartId;

    @NotBlank(message = "packagingGroup can't be empty!")
    private String toSecondaryNo;

    private String toPrimaryNo;

    private String toLayerNo;

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public String getBomPartId() {
        return bomPartId;
    }

    public void setBomPartId(String partNo) {
        this.bomPartId = partNo;
    }

    public String getToSecondaryNo() {
        return toSecondaryNo;
    }

    public void setToSecondaryNo(String toSecondaryNo) {
        this.toSecondaryNo = toSecondaryNo;
    }

    public String getToPrimaryNo() {
        return toPrimaryNo;
    }

    public void setToPrimaryNo(String toPrimaryNo) {
        this.toPrimaryNo = toPrimaryNo;
    }

    public String getToLayerNo() {
        return toLayerNo;
    }

    public void setToLayerNo(String toLayerNo) {
        this.toLayerNo = toLayerNo;
    }
}