package com.spaceage.logistics.Model.MySQL;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_master")
public class ItemMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "customer_code")
    private Integer customerCode;

    @Column(name = "project_code")
    private Integer projectCode;

    @Column(name = "org_country_id")
    private Integer orgCountryId;

    @Column(name = "packing_type")
    private Integer packingType;

    @Column(name = "lot_size")
    private String lotSize;

    @Column(name = "customer_login")
    private Integer customerLogin;

    @Column(name = "lot_ref_no")
    private String lotRefNo;

    @Column(name = "containers")
    private String containers;

    @Column(name = "CreatedBy")
    private Integer createdBy = 1;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy = 1;

    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    @Column(name = "Status")
    private Boolean status = true;

    // Getters and Setters

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Integer customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Integer projectCode) {
        this.projectCode = projectCode;
    }

    public Integer getOrgCountryId() {
        return orgCountryId;
    }

    public void setOrgCountryId(Integer orgCountryId) {
        this.orgCountryId = orgCountryId;
    }

    public Integer getPackingType() {
        return packingType;
    }

    public void setPackingType(Integer packingType) {
        this.packingType = packingType;
    }

    public String getLotSize() {
        return lotSize;
    }

    public void setLotSize(String lotSize) {
        this.lotSize = lotSize;
    }

    public Integer getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(Integer customerLogin) {
        this.customerLogin = customerLogin;
    }

    public String getLotRefNo() {
        return lotRefNo;
    }

    public void setLotRefNo(String lotRefNo) {
        this.lotRefNo = lotRefNo;
    }

    public String getContainers() {
        return containers;
    }

    public void setContainers(String containers) {
        this.containers = containers;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
