package com.spaceage.logistics.Payload.Request.Packaging;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EditDetailsRequest {

    @NotBlank(message = "bomTableId can't be null")
    private String bomTableId;

    @NotBlank(message = "originCustomerId can't be null")
    private String originCustomerId;

    @NotBlank(message = "endCustomerId can't be null")
    private String endCustomerId;

    @NotBlank(message = "projectId can't be null")
    private String projectId;

    @NotBlank(message = "modelId can't be null")
    private String modelId;

    @NotNull(message = "Lot size cannot be null")
    @Min(value = 0, message = "Lot size must be greater or equal to zero")
    @Digits(integer = 10, fraction = 0, message = "Lot size must be a numeric value without decimals")
    private Long lotSize;

    @NotNull(message = "Container count cannot be null")
    @Min(value = 0, message = "Container count must be greater than zero")
    @Digits(integer = 10, fraction = 0, message = "Container count must be a numeric value without decimals")
    private Long containerCount;

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public String getOriginCustomerId() {
        return originCustomerId;
    }

    public void setOriginCustomerId(String originCustomerId) {
        this.originCustomerId = originCustomerId;
    }

    public String getEndCustomerId() {
        return endCustomerId;
    }

    public void setEndCustomerId(String endCustomerId) {
        this.endCustomerId = endCustomerId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Long getLotSize() {
        return lotSize;
    }

    public void setLotSize(Long lotSize) {
        this.lotSize = lotSize;
    }

    public Long getContainerCount() {
        return containerCount;
    }

    public void setContainerCount(Long containerCount) {
        this.containerCount = containerCount;
    }
}
