package com.spaceage.logistics.Payload.DTO;

import com.spaceage.logistics.Payload.enums.*;
import java.util.Date;

public class BomTableDTO {
    private String bomTableId;
    private String lotRefNo;
    private Long partCount;
    private Long mirnPartCount;
    private Long pendingForPickupPartCount;
    private Long acknowledgedPartCount;
    private Long qcFailedPartCount;
    private Long partlabelPartCount;
    private Long bomcompletePartCount;
    private Long errorPartCount;
    private String s3Location;
    private String s3Key;

    private BomTableStatus status;
    private BomAcknowledgementStatus acknowledgementStatus;
    private BomQualityCheckStatus qualityCheckStatus;
    private BomPartLabelStatus partLabelStatus;

    private String MIRN_Url;
    private String qualityCheckUrl;
    private String partLabelUrl;

    private Long lotSize;
    private Long containerCount;
    private ShippingLoc shippingLoc;

    private Date createdAt;
    private Date updatedAt;

    // IDs of related entities instead of objects
    private String modelId;
    private String projectId;
    private String endCustomerId;
    private String originCustomerId;
    private String createdById;
    private String updatedById;

    // Constructor
    public BomTableDTO(
            String bomTableId, String lotRefNo, Long partCount, Long mirnPartCount,
            Long pendingForPickupPartCount, Long acknowledgedPartCount, Long qcFailedPartCount,
            Long partlabelPartCount, Long bomcompletePartCount, Long errorPartCount,
            String s3Location, String s3Key, BomTableStatus status, BomAcknowledgementStatus acknowledgementStatus,
            BomQualityCheckStatus qualityCheckStatus, BomPartLabelStatus partLabelStatus, String MIRN_Url,
            String qualityCheckUrl, String partLabelUrl, Long lotSize, Long containerCount, ShippingLoc shippingLoc,
            Date createdAt, Date updatedAt, String modelId, String projectId, String endCustomerId,
            String originCustomerId, String createdById, String updatedById) {
        this.bomTableId = bomTableId;
        this.lotRefNo = lotRefNo;
        this.partCount = partCount;
        this.mirnPartCount = mirnPartCount;
        this.pendingForPickupPartCount = pendingForPickupPartCount;
        this.acknowledgedPartCount = acknowledgedPartCount;
        this.qcFailedPartCount = qcFailedPartCount;
        this.partlabelPartCount = partlabelPartCount;
        this.bomcompletePartCount = bomcompletePartCount;
        this.errorPartCount = errorPartCount;
        this.s3Location = s3Location;
        this.s3Key = s3Key;
        this.status = status;
        this.acknowledgementStatus = acknowledgementStatus;
        this.qualityCheckStatus = qualityCheckStatus;
        this.partLabelStatus = partLabelStatus;
        this.MIRN_Url = MIRN_Url;
        this.qualityCheckUrl = qualityCheckUrl;
        this.partLabelUrl = partLabelUrl;
        this.lotSize = lotSize;
        this.containerCount = containerCount;
        this.shippingLoc = shippingLoc;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.modelId = modelId;
        this.projectId = projectId;
        this.endCustomerId = endCustomerId;
        this.originCustomerId = originCustomerId;
        this.createdById = createdById;
        this.updatedById = updatedById;
    }

    // Getters and Setters
    public String getBomTableId() { return bomTableId; }
    public void setBomTableId(String bomTableId) { this.bomTableId = bomTableId; }

    public String getLotRefNo() { return lotRefNo; }
    public void setLotRefNo(String lotRefNo) { this.lotRefNo = lotRefNo; }

    public Long getPartCount() { return partCount; }
    public void setPartCount(Long partCount) { this.partCount = partCount; }

    public String getS3Location() { return s3Location; }
    public void setS3Location(String s3Location) { this.s3Location = s3Location; }

    public String getS3Key() { return s3Key; }
    public void setS3Key(String s3Key) { this.s3Key = s3Key; }

    public BomTableStatus getStatus() { return status; }
    public void setStatus(BomTableStatus status) { this.status = status; }

    public BomAcknowledgementStatus getAcknowledgementStatus() { return acknowledgementStatus; }
    public void setAcknowledgementStatus(BomAcknowledgementStatus acknowledgementStatus) { this.acknowledgementStatus = acknowledgementStatus; }

    public BomQualityCheckStatus getQualityCheckStatus() { return qualityCheckStatus; }
    public void setQualityCheckStatus(BomQualityCheckStatus qualityCheckStatus) { this.qualityCheckStatus = qualityCheckStatus; }

    public BomPartLabelStatus getPartLabelStatus() { return partLabelStatus; }
    public void setPartLabelStatus(BomPartLabelStatus partLabelStatus) { this.partLabelStatus = partLabelStatus; }

    public String getMIRN_Url() { return MIRN_Url; }
    public void setMIRN_Url(String MIRN_Url) { this.MIRN_Url = MIRN_Url; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public String getModelId() { return modelId; }
    public void setModelId(String modelId) { this.modelId = modelId; }

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public String getEndCustomerId() { return endCustomerId; }
    public void setEndCustomerId(String endCustomerId) { this.endCustomerId = endCustomerId; }

    public String getOriginCustomerId() { return originCustomerId; }
    public void setOriginCustomerId(String originCustomerId) { this.originCustomerId = originCustomerId; }

    public String getCreatedById() { return createdById; }
    public void setCreatedById(String createdById) { this.createdById = createdById; }

    public String getUpdatedById() { return updatedById; }
    public void setUpdatedById(String updatedById) { this.updatedById = updatedById; }

    public Long getMirnPartCount() {
        return mirnPartCount;
    }

    public void setMirnPartCount(Long mirnPartCount) {
        this.mirnPartCount = mirnPartCount;
    }

    public Long getPendingForPickupPartCount() {
        return pendingForPickupPartCount;
    }

    public void setPendingForPickupPartCount(Long pendingForPickupPartCount) {
        this.pendingForPickupPartCount = pendingForPickupPartCount;
    }

    public Long getAcknowledgedPartCount() {
        return acknowledgedPartCount;
    }

    public void setAcknowledgedPartCount(Long acknowledgedPartCount) {
        this.acknowledgedPartCount = acknowledgedPartCount;
    }

    public Long getQcFailedPartCount() {
        return qcFailedPartCount;
    }

    public void setQcFailedPartCount(Long qcFailedPartCount) {
        this.qcFailedPartCount = qcFailedPartCount;
    }

    public Long getPartlabelPartCount() {
        return partlabelPartCount;
    }

    public void setPartlabelPartCount(Long partlabelPartCount) {
        this.partlabelPartCount = partlabelPartCount;
    }

    public Long getBomcompletePartCount() {
        return bomcompletePartCount;
    }

    public void setBomcompletePartCount(Long bomcompletePartCount) {
        this.bomcompletePartCount = bomcompletePartCount;
    }

    public Long getErrorPartCount() {
        return errorPartCount;
    }

    public void setErrorPartCount(Long errorPartCount) {
        this.errorPartCount = errorPartCount;
    }

    public String getQualityCheckUrl() {
        return qualityCheckUrl;
    }

    public void setQualityCheckUrl(String qualityCheckUrl) {
        this.qualityCheckUrl = qualityCheckUrl;
    }

    public String getPartLabelUrl() {
        return partLabelUrl;
    }

    public void setPartLabelUrl(String partLabelUrl) {
        this.partLabelUrl = partLabelUrl;
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

    public ShippingLoc getShippingLoc() {
        return shippingLoc;
    }

    public void setShippingLoc(ShippingLoc shippingLoc) {
        this.shippingLoc = shippingLoc;
    }
}