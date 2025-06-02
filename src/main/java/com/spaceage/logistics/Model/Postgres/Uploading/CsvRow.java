package com.spaceage.logistics.Model.Postgres.Uploading;

public class CsvRow {
    private long bomNo;
    private String partNo;
    private String partDescription;
    private long version;
    private String stLocation;
    private String validity;
    private String catDescription;
    private long qtyRequired;
    private long qtyLot;
    private String partType;
    private String layerNo;
    private String primaryNo;
    private String secondaryNo;
    private String packCode;
    private long packQty;
    private String packingGroup;
    private long totalPackingGroup;
    private long mixGroup;
    private long mixBox;
    private long mixLayer;
    private long mixPartType;
    private long caseMap;
    private String imageUrl;

    public CsvRow() {
    }

    public CsvRow(String lotRefNo, String partNo, String partDescription, int version, String stLocation, String validity, String catDescription, String qtyRequired, String s, String s1, String s2, String packCode, String packQty, String packingGroup, String totalNoOfPackingGroup, String mixGroup, String mix, String s3, String caseMap, String images) {
        this.partNo = partNo;
        this.partDescription = partDescription;
        this.version = version;
        this.stLocation = stLocation;
        this.validity = validity;
        this.catDescription = catDescription;

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


    public String getPackingGroup() {
        return packingGroup;
    }

    public void setPackingGroup(String packingGroup) {
        this.packingGroup = packingGroup;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public long getQtyRequired() {
        return qtyRequired;
    }

    public void setQtyRequired(long qtyRequired) {
        this.qtyRequired = qtyRequired;
    }

    public long getQtyLot() {
        return qtyLot;
    }

    public void setQtyLot(long qtyLot) {
        this.qtyLot = qtyLot;
    }

    public long getPackQty() {
        return packQty;
    }

    public void setPackQty(long packQty) {
        this.packQty = packQty;
    }

    public long getTotalPackingGroup() {
        return totalPackingGroup;
    }

    public void setTotalPackingGroup(long totalPackingGroup) {
        this.totalPackingGroup = totalPackingGroup;
    }

    public long getMixGroup() {
        return mixGroup;
    }

    public void setMixGroup(long mixGroup) {
        this.mixGroup = mixGroup;
    }

    public long getMixBox() {
        return mixBox;
    }

    public void setMixBox(long mixBox) {
        this.mixBox = mixBox;
    }

    public long getMixLayer() {
        return mixLayer;
    }

    public void setMixLayer(long mixLayer) {
        this.mixLayer = mixLayer;
    }

    public long getMixPartType() {
        return mixPartType;
    }

    public void setMixPartType(long mixPartType) {
        this.mixPartType = mixPartType;
    }

    public long getBomNo() {
        return bomNo;
    }

    public void setBomNo(long bomNo) {
        this.bomNo = bomNo;
    }

    public long getCaseMap() {
        return caseMap;
    }

    public void setCaseMap(long caseMap) {
        this.caseMap = caseMap;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getLayerNo() {
        return layerNo;
    }

    public void setLayerNo(String layerNo) {
        this.layerNo = layerNo;
    }
}
