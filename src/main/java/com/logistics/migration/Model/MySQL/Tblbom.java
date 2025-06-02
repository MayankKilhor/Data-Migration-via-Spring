package com.logistics.migration.Model.MySQL;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblbom")
public class Tblbom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOM_ID")
    private Integer bomId;

    @Column(name = "lot_ref_no")
    private String lotRefNo;

    @Column(name = "PART_NO")
    private String partNo;

    @Column(name = "PART_DESCRIPTION")
    private String partDescription;

    @Column(name = "Version")
    private String version;

    @Column(name = "ST_LOCATION")
    private String stLocation;

    @Column(name = "VALIDITY")
    private String validity;

    @Column(name = "CAT_Description")
    private String catDescription;

    @Column(name = "QTY_REQUIRED")
    private String qtyRequired;

    @Column(name = "Qty_Lot")
    private String qtyLot;

    @Column(name = "Primary_NO")
    private String primaryNo;

    @Column(name = "Secondary_NO")
    private String secondaryNo;

    @Column(name = "Pack_Code")
    private String packCode;

    @Column(name = "Pack_Qty")
    private String packQty;

    @Column(name = "Packing_Group")
    private String packingGroup;

    @Column(name = "Total_No_of_Packing_Group")
    private String totalNoOfPackingGroup;

    @Column(name = "Mix_Group")
    private String mixGroup;

    @Column(name = "Mix")
    private String mix;

    @Column(name = "BomNo")
    private String bomNo;

    @Column(name = "Case_map")
    private String caseMap;

    @Column(name = "Images")
    private String images;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @Column(name = "ModifiedDate")
    private Date modifiedDate;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "pick_label_scan")
    private Integer pickLabelScan;

    @Column(name = "Part_label_scan")
    private Integer partLabelScan;

    @Column(name = "pendingDate")
    private Date pendingDate;

    @Column(name = "ackDate")
    private Date ackDate;

    @Column(name = "receivedDate")
    private Date receivedDate;

    @Column(name = "packedDate")
    private Date packedDate;

    @Column(name = "item_id")
    private Integer itemId;

    // Getters and Setters

    public Integer getBomId() {
        return bomId;
    }

    public void setBomId(Integer bomId) {
        this.bomId = bomId;
    }

    public String getLotRefNo() {
        return lotRefNo;
    }

    public void setLotRefNo(String lotRefNo) {
        this.lotRefNo = lotRefNo;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStLocation() {
        return stLocation;
    }

    public void setStLocation(String stLocation) {
        this.stLocation = stLocation;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getQtyRequired() {
        return qtyRequired;
    }

    public void setQtyRequired(String qtyRequired) {
        this.qtyRequired = qtyRequired;
    }

    public String getQtyLot() {
        return qtyLot;
    }

    public void setQtyLot(String qtyLot) {
        this.qtyLot = qtyLot;
    }

    public String getPrimaryNo() {
        return primaryNo;
    }

    public void setPrimaryNo(String primaryNo) {
        this.primaryNo = primaryNo;
    }

    public String getSecondaryNo() {
        return secondaryNo;
    }

    public void setSecondaryNo(String secondaryNo) {
        this.secondaryNo = secondaryNo;
    }

    public String getPackCode() {
        return packCode;
    }

    public void setPackCode(String packCode) {
        this.packCode = packCode;
    }

    public String getPackQty() {
        return packQty;
    }

    public void setPackQty(String packQty) {
        this.packQty = packQty;
    }

    public String getPackingGroup() {
        return packingGroup;
    }

    public void setPackingGroup(String packingGroup) {
        this.packingGroup = packingGroup;
    }

    public String getTotalNoOfPackingGroup() {
        return totalNoOfPackingGroup;
    }

    public void setTotalNoOfPackingGroup(String totalNoOfPackingGroup) {
        this.totalNoOfPackingGroup = totalNoOfPackingGroup;
    }

    public String getMixGroup() {
        return mixGroup;
    }

    public void setMixGroup(String mixGroup) {
        this.mixGroup = mixGroup;
    }

    public String getMix() {
        return mix;
    }

    public void setMix(String mix) {
        this.mix = mix;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public String getCaseMap() {
        return caseMap;
    }

    public void setCaseMap(String caseMap) {
        this.caseMap = caseMap;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getPickLabelScan() {
        return pickLabelScan;
    }

    public void setPickLabelScan(Integer pickLabelScan) {
        this.pickLabelScan = pickLabelScan;
    }

    public Integer getPartLabelScan() {
        return partLabelScan;
    }

    public void setPartLabelScan(Integer partLabelScan) {
        this.partLabelScan = partLabelScan;
    }

    public Date getPendingDate() {
        return pendingDate;
    }

    public void setPendingDate(Date pendingDate) {
        this.pendingDate = pendingDate;
    }

    public Date getAckDate() {
        return ackDate;
    }

    public void setAckDate(Date ackDate) {
        this.ackDate = ackDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getPackedDate() {
        return packedDate;
    }

    public void setPackedDate(Date packedDate) {
        this.packedDate = packedDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
