package com.spaceage.logistics.Payload.Request.BOM;

import com.spaceage.logistics.Payload.enums.BomPartLabelRequestEnum;
import jakarta.validation.constraints.NotBlank;

public class BOMPartLabelRequest {


    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    private BomPartLabelRequestEnum type;

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public BomPartLabelRequestEnum getType() {
        return type;
    }

    public void setType(BomPartLabelRequestEnum type) {
        this.type = type;
    }
}
