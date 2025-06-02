package com.spaceage.logistics.Payload.Request.BOM;

public class addBomPart {

    private String partNo;
    private String partDescription;
    private Integer version;
    private String stLocation;
    private String validity;
    private String catDescription;
    private Integer qtyRequired;
    private Integer qtyPerLot;
    private String primaryNo;
    private String secondaryNo;
    private String packCode;
    private Integer packQty;
    private String packingGroup;
    private Integer totalNoOfPackingGroup;
    private Integer mixGroup;
    private String mix;
    private Integer bomNo;
    private Integer caseMap;
    private String images;

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
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

    public Integer getQtyRequired() {
        return qtyRequired;
    }

    public void setQtyRequired(Integer qtyRequired) {
        this.qtyRequired = qtyRequired;
    }

    public Integer getQtyPerLot() {
        return qtyPerLot;
    }

    public void setQtyPerLot(Integer qtyPerLot) {
        this.qtyPerLot = qtyPerLot;
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

    public Integer getPackQty() {
        return packQty;
    }

    public void setPackQty(Integer packQty) {
        this.packQty = packQty;
    }

    public String getPackingGroup() {
        return packingGroup;
    }

    public void setPackingGroup(String packingGroup) {
        this.packingGroup = packingGroup;
    }

    public Integer getTotalNoOfPackingGroup() {
        return totalNoOfPackingGroup;
    }

    public void setTotalNoOfPackingGroup(Integer totalNoOfPackingGroup) {
        this.totalNoOfPackingGroup = totalNoOfPackingGroup;
    }

    public Integer getMixGroup() {
        return mixGroup;
    }

    public void setMixGroup(Integer mixGroup) {
        this.mixGroup = mixGroup;
    }

    public String getMix() {
        return mix;
    }

    public void setMix(String mix) {
        this.mix = mix;
    }

    public Integer getBomNo() {
        return bomNo;
    }

    public void setBomNo(Integer bomNo) {
        this.bomNo = bomNo;
    }

    public Integer getCaseMap() {
        return caseMap;
    }

    public void setCaseMap(Integer caseMap) {
        this.caseMap = caseMap;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
