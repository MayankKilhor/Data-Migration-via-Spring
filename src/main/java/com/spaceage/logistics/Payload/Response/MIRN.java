package com.spaceage.logistics.Payload.Response;

public class MIRN {

    private int bomNo;

    private String lotRefNo;

    private String partNo;

    private String partDescription;

    private String catDescription;

    private String secondary;

    private String  pkgGroup;

    private long pkgCount;

    private String partType;

    private long version;

    private String packCode;

    private String validity;

    private String imageUrl;

    private long qtyRequired;

    private long packQty;

    private String userName;

    private Long totalNoOfPackingGroup;

    private String stLocation;

    public int getBomNo() {
        return bomNo;
    }

    public void setBomNo(int bomNo) {
        this.bomNo = bomNo;
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

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String  getPkgGroup() {
        return pkgGroup;
    }

    public void setPkgGroup(String pkgGroup) {
        this.pkgGroup = pkgGroup;
    }

    public long getPkgCount() {
        return pkgCount;
    }

    public void setPkgCount(long pkgCount) {
        this.pkgCount = pkgCount;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getPackCode() {
        return packCode;
    }

    public void setPackCode(String packCode) {
        this.packCode = packCode;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getQtyRequired() {
        return qtyRequired;
    }

    public void setQtyRequired(long qtyRequired) {
        this.qtyRequired = qtyRequired;
    }

    public long getPackQty() {
        return packQty;
    }

    public void setPackQty(long packQty) {
        this.packQty = packQty;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getTotalNoOfPackingGroup() {
        return totalNoOfPackingGroup;
    }

    public void setTotalNoOfPackingGroup(Long totalNoOfPackingGroup) {
        this.totalNoOfPackingGroup = totalNoOfPackingGroup;
    }

    public String getStLocation() {
        return stLocation;
    }

    public void setStLocation(String stLocation) {
        this.stLocation = stLocation;
    }
}
