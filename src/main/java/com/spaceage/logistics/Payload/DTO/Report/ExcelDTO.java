package com.spaceage.logistics.Payload.DTO.Report;

import com.spaceage.logistics.Model.Postgres.Uploading.BomTable;
import com.spaceage.logistics.Payload.enums.*;

import java.util.Date;

public class ExcelDTO {

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
    private String modelName;
    private String modelDescription;
    private String projectId;
    private String projectName;
    private String projectDescription;
    private String endCustomerId;
    private String endCustomerName;
    private String endCustomerDescription;
    private String endCustomerCountry;
    private String originCustomerId;
    private String originCustomerName;
    private String originCustomerDescription;
    private String originCustomerCountry;
    private String createdById;
    private String updatedById;

    public ExcelDTO(BomTable bomTable) {
        this.bomTableId = bomTable.getBomTableId();
        this.lotRefNo = bomTable.getLotRefNo();
        this.partCount = bomTable.getPartCount();
        this.mirnPartCount = bomTable.getMirnPartCount();
        this.pendingForPickupPartCount = bomTable.getPendingForPickupPartCount();
        this.acknowledgedPartCount = bomTable.getAcknowledgedPartCount();
        this.qcFailedPartCount = bomTable.getQcFailedPartCount();
        this.partlabelPartCount = bomTable.getPartlabelPartCount();
        this.bomcompletePartCount = bomTable.getBomcompletePartCount();
        this.errorPartCount = bomTable.getErrorPartCount();
        this.s3Location = bomTable.getS3Location();
        this.s3Key = bomTable.getS3Key();
        this.status = bomTable.getStatus();
        this.acknowledgementStatus = bomTable.getAcknowledgementStatus();
        this.qualityCheckStatus = bomTable.getQualityCheckStatus();
        this.partLabelStatus = bomTable.getPartLabelStatus();
        this.MIRN_Url = bomTable.getMIRN_Url();
        this.qualityCheckUrl = bomTable.getQualityCheckUrl();
        this.partLabelUrl = bomTable.getPartLabelUrl();
        this.lotSize = bomTable.getLotSize();
        this.containerCount = bomTable.getContainerCount();
        this.shippingLoc = bomTable.getShippingLoc();
        this.createdAt = bomTable.getCreatedAt();
        this.updatedAt = bomTable.getUpdatedAt();
        this.modelId = bomTable.getModel().getModelId();
        this.modelName = bomTable.getModel().getName();
        this.modelDescription = bomTable.getModel().getDescription();
        this.projectId = bomTable.getProject().getProjectId();
        this.projectName = bomTable.getProject().getName();
        this.projectDescription = bomTable.getProject().getDescription();
        this.endCustomerId = bomTable.getEndCustomer().getEndCustomerId();
        this.endCustomerName = bomTable.getEndCustomer().getName();
        this.endCustomerDescription = bomTable.getEndCustomer().getDescription();
        this.endCustomerCountry = bomTable.getEndCustomer().getCountry();
        this.originCustomerId = bomTable.getOriginCustomer().getOriginCustomerId();
        this.originCustomerName = bomTable.getOriginCustomer().getName();
        this.originCustomerDescription = bomTable.getOriginCustomer().getDescription();
        this.originCustomerCountry = bomTable.getOriginCustomer().getCountry();
        this.createdById = bomTable.getCreatedBy().getUserId();
        this.updatedById = bomTable.getUpdatedBy().getUserId();
    }

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

    public String getS3Location() {
        return s3Location;
    }

    public void setS3Location(String s3Location) {
        this.s3Location = s3Location;
    }

    public String getS3Key() {
        return s3Key;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }

    public BomTableStatus getStatus() {
        return status;
    }

    public void setStatus(BomTableStatus status) {
        this.status = status;
    }

    public BomAcknowledgementStatus getAcknowledgementStatus() {
        return acknowledgementStatus;
    }

    public void setAcknowledgementStatus(BomAcknowledgementStatus acknowledgementStatus) {
        this.acknowledgementStatus = acknowledgementStatus;
    }

    public BomQualityCheckStatus getQualityCheckStatus() {
        return qualityCheckStatus;
    }

    public void setQualityCheckStatus(BomQualityCheckStatus qualityCheckStatus) {
        this.qualityCheckStatus = qualityCheckStatus;
    }

    public BomPartLabelStatus getPartLabelStatus() {
        return partLabelStatus;
    }

    public void setPartLabelStatus(BomPartLabelStatus partLabelStatus) {
        this.partLabelStatus = partLabelStatus;
    }

    public String getMIRN_Url() {
        return MIRN_Url;
    }

    public void setMIRN_Url(String MIRN_Url) {
        this.MIRN_Url = MIRN_Url;
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

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getEndCustomerId() {
        return endCustomerId;
    }

    public void setEndCustomerId(String endCustomerId) {
        this.endCustomerId = endCustomerId;
    }

    public String getEndCustomerName() {
        return endCustomerName;
    }

    public void setEndCustomerName(String endCustomerName) {
        this.endCustomerName = endCustomerName;
    }

    public String getEndCustomerDescription() {
        return endCustomerDescription;
    }

    public void setEndCustomerDescription(String endCustomerDescription) {
        this.endCustomerDescription = endCustomerDescription;
    }

    public String getEndCustomerCountry() {
        return endCustomerCountry;
    }

    public void setEndCustomerCountry(String endCustomerCountry) {
        this.endCustomerCountry = endCustomerCountry;
    }

    public String getOriginCustomerId() {
        return originCustomerId;
    }

    public void setOriginCustomerId(String originCustomerId) {
        this.originCustomerId = originCustomerId;
    }

    public String getOriginCustomerName() {
        return originCustomerName;
    }

    public void setOriginCustomerName(String originCustomerName) {
        this.originCustomerName = originCustomerName;
    }

    public String getOriginCustomerDescription() {
        return originCustomerDescription;
    }

    public void setOriginCustomerDescription(String originCustomerDescription) {
        this.originCustomerDescription = originCustomerDescription;
    }

    public String getOriginCustomerCountry() {
        return originCustomerCountry;
    }

    public void setOriginCustomerCountry(String originCustomerCountry) {
        this.originCustomerCountry = originCustomerCountry;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(String updatedById) {
        this.updatedById = updatedById;
    }
}