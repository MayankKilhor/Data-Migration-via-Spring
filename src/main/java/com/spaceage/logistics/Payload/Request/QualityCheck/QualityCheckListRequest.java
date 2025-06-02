package com.spaceage.logistics.Payload.Request.QualityCheck;

import jakarta.validation.constraints.NotBlank;

public class QualityCheckListRequest {

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }
}

