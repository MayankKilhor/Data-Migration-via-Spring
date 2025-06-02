package com.spaceage.logistics.Payload.Request.Barcode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QualityCheckPartRequest {

    @NotBlank(message = "partNo can't be empty!")
    private String partNo;

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    @NotNull(message = "qualityCheck can't be null!")
    private boolean qualityCheck;

    private String reason;

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

    public boolean isQualityCheck() {
        return qualityCheck;
    }

    public void setQualityCheck(boolean qualityCheck) {
        this.qualityCheck = qualityCheck;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
