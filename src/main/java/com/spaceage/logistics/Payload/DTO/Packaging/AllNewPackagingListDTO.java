package com.spaceage.logistics.Payload.DTO.Packaging;

import com.spaceage.logistics.Model.Postgres.Uploading.BomTable;

import java.util.Date;

public class AllNewPackagingListDTO {

    private String bomTableId;

    private String lotRefNo;

    private Long partCount;

    private String modelId;

    private String projectId;

    private String originCustomerId;

    private String endCustomerId;

    private Date createdAt;

    private Date updatedAt;

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public String getLotRefNo() {
        return lotRefNo;
    }

    public void setLotRefNo(String lotRefNo) {
        this.lotRefNo = lotRefNo;
    }

    public Long getPartCount() {
        return partCount;
    }

    public void setPartCount(Long partCount) {
        this.partCount = partCount;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AllNewPackagingListDTO() {
    }

    public static AllNewPackagingListDTO toDTO(BomTable bomTable) {
        AllNewPackagingListDTO dto = new AllNewPackagingListDTO();
        dto.setBomTableId(bomTable.getBomTableId());
        dto.setLotRefNo(bomTable.getLotRefNo());
        dto.setModelId(bomTable.getModel().getModelId());
        dto.setProjectId(bomTable.getProject().getProjectId());
        dto.setOriginCustomerId(bomTable.getOriginCustomer().getOriginCustomerId());
        dto.setEndCustomerId(bomTable.getEndCustomer().getEndCustomerId());
        dto.setCreatedAt(bomTable.getCreatedAt());
        dto.setUpdatedAt(bomTable.getUpdatedAt());
        dto.setPartCount(bomTable.getPartCount());

        return dto;
    }
}
