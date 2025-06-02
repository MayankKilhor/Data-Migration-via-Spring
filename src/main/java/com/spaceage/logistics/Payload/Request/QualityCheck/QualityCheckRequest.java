package com.spaceage.logistics.Payload.Request.QualityCheck;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class QualityCheckRequest {

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    List<QualityCheckUpdateRequest> qualityChecks;

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public List<QualityCheckUpdateRequest> getQualityChecks() {
        return qualityChecks;
    }

    public void setQualityChecks(List<QualityCheckUpdateRequest> qualityChecks) {
        this.qualityChecks = qualityChecks;
    }
}

