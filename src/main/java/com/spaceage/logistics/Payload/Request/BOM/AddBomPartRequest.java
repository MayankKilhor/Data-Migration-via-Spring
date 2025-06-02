package com.spaceage.logistics.Payload.Request.BOM;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class AddBomPartRequest {
    @NotBlank(message = "bomTableId can't be empty!")
    String bomTableId;

    List<addBomPart> bomParts;

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public List<addBomPart> getBillOfMaterials() {
        return bomParts;
    }

    public List<addBomPart> getBomParts() {
        return bomParts;
    }

    public void setBomParts(List<addBomPart> bomParts) {
        this.bomParts = bomParts;
    }

    public void setBillOfMaterials(List<addBomPart> billOfMaterials) {
        this.bomParts = billOfMaterials;
    }
}
