package com.spaceage.logistics.Payload.Request.QualityCheck;

public class QualityCheckUpdateRequest {
    private String bomPartId;
    private boolean qualityCheck;
    private String reason;

    public String getBomPartId() {
        return bomPartId;
    }

    public void setBomPartId(String bomPartId) {
        this.bomPartId = bomPartId;
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
