package com.spaceage.logistics.Payload.Request.BOM;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BOMVerificationRequest {


    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    @NotNull(message = "isCorrect can't be null")
    private Boolean isCorrect;


    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }
}
