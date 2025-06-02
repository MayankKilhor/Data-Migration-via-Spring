package com.spaceage.logistics.Payload.Response;


import com.spaceage.logistics.Model.Postgres.Part;

public class PartLabel {

    private String partId;

    private String partNo;

    private Integer bomNo;

    private String partDescription;

    private Long version;

    private String stLocation;

    private String validity;

    private String catDescription;

    private String partType;

    private String primaryNo;

    private String secondaryNo;

    private String layerNo;

    private String packCode;

    private Long qtyRequired;

    private Long packQty;

    private String packingGroup;

    private Long totalNoOfPackingGroup;

    private long mixPartType;

    private Long mixGroup;

    private Long mixBox;

    private Long mixLayer;

    private Long caseMap;

    private Long packingGroupIndex;

    private String images;

    private String uploadedImage;


    private String creatorUserName;

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public Integer getBomNo() {
        return bomNo;
    }

    public void setBomNo(Integer bomNo) {
        this.bomNo = bomNo;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
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

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
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

    public String getLayerNo() {
        return layerNo;
    }

    public void setLayerNo(String layerNo) {
        this.layerNo = layerNo;
    }

    public String getPackCode() {
        return packCode;
    }

    public void setPackCode(String packCode) {
        this.packCode = packCode;
    }

    public Long getPackQty() {
        return packQty;
    }

    public void setPackQty(Long packQty) {
        this.packQty = packQty;
    }

    public String getPackingGroup() {
        return packingGroup;
    }

    public void setPackingGroup(String packingGroup) {
        this.packingGroup = packingGroup;
    }

    public Long getTotalNoOfPackingGroup() {
        return totalNoOfPackingGroup;
    }

    public void setTotalNoOfPackingGroup(Long totalNoOfPackingGroup) {
        this.totalNoOfPackingGroup = totalNoOfPackingGroup;
    }

    public long getMixPartType() {
        return mixPartType;
    }

    public void setMixPartType(long mixPartType) {
        this.mixPartType = mixPartType;
    }

    public Long getMixGroup() {
        return mixGroup;
    }

    public void setMixGroup(Long mixGroup) {
        this.mixGroup = mixGroup;
    }

    public Long getMixBox() {
        return mixBox;
    }

    public void setMixBox(Long mixBox) {
        this.mixBox = mixBox;
    }

    public Long getMixLayer() {
        return mixLayer;
    }

    public void setMixLayer(Long mixLayer) {
        this.mixLayer = mixLayer;
    }

    public Long getCaseMap() {
        return caseMap;
    }

    public void setCaseMap(Long caseMap) {
        this.caseMap = caseMap;
    }

    public Long getPackingGroupIndex() {
        return packingGroupIndex;
    }

    public void setPackingGroupIndex(Long packingGroupIndex) {
        this.packingGroupIndex = packingGroupIndex;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getUploadedImage() {
        return uploadedImage;
    }

    public void setUploadedImage(String uploadedImage) {
        this.uploadedImage = uploadedImage;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
    }

    public PartLabel() {
    }

    public PartLabel(Part part, String creatorUserName) {
        this.partId = part.getPartId();
        this.partNo = part.getPartNo();
        this.bomNo = part.getBomNo();
        this.partDescription = part.getPartDescription();
        this.version = part.getVersion();
        this.stLocation = part.getStLocation();
        this.validity = part.getValidity();
        this.catDescription = part.getCatDescription();
        this.partType = part.getPartType();
        this.primaryNo = part.getPrimaryNo();
        this.secondaryNo = part.getSecondaryNo();
        this.layerNo = part.getLayerNo();
        this.packCode = part.getPackCode();
        this.qtyRequired = part.getQtyRequired();
        this.packQty = part.getPackQty();
        this.packingGroup = part.getPackingGroup();
        this.totalNoOfPackingGroup = part.getTotalNoOfPackingGroup();
        this.mixPartType = part.getMixPartType();
        this.mixGroup = part.getMixGroup();
        this.mixBox = part.getMixBox();
        this.mixLayer = part.getMixLayer();
        this.caseMap = part.getCaseMap();
        this.packingGroupIndex = part.getPackingGroupIndex();
        this.images = part.getImages();
        this.uploadedImage = part.getUploadedImage();
        this.creatorUserName = creatorUserName;
    }

    public Long getQtyRequired() {
        return qtyRequired;
    }

    public void setQtyRequired(Long qtyRequired) {
        this.qtyRequired = qtyRequired;
    }
}
