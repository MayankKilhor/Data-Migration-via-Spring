package com.logistics.migration.Model.Postgres;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.logistics.migration.Model.Postgres.Security.User;
import com.logistics.migration.Model.Postgres.Uploading.BomPart;
import com.logistics.migration.Model.Postgres.Uploading.BomTable;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "part")
public class Part {

    @Id
    @Column(name = "part_id", nullable = false)
    private String partId;

    @Column(name = "bom_no")
    private Integer bomNo;

    @Column(name = "part_no")
    private String partNo;

    @Column(name = "bom_part_id",nullable = false)
    private String bomPartId;

    @Column(name = "part_description")
    private String partDescription;

    @Column(name = "version")
    private Long version;

    @Column(name = "st_location")
    private String stLocation;

    @Column(name = "validity")
    private String validity;

    @Column(name = "cat_description")
    private String catDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bomtable_id",nullable = false, foreignKey = @ForeignKey(name = "fk_bomTable"))
    @JsonBackReference("parts")
    private BomTable bomTable;



//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pallet_id",foreignKey = @ForeignKey(name = "fk_pallet"))
//    @JsonBackReference
//    private Pallet pallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pallet_id", foreignKey = @ForeignKey(name = "fk_part_pallet"))
    private Pallet pallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id", foreignKey = @ForeignKey(name = "fk_part_box"))
    private Box box;


    @Column(name = "qty_required")
    private Long qtyRequired;

    @Column(name = "qty_per_lot")
    private Long qtyPerLot;

    @Column(name = "part_type")
    private String partType;

    @Column(name = "primary_no")
    private String primaryNo;

    @Column(name = "secondary_no")
    private String secondaryNo;

    @Column(name = "layer_no")
    private String layerNo;

    @Column(name = "pack_code")
    private String packCode;

    @Column(name = "pack_qty")
    private Long packQty;

    @Column(name = "packing_group")
    private String packingGroup;

    @Column(name = "packing_group_index")
    private Long packingGroupIndex;

    @Column(name = "total_no_of_packing_group")
    private Long totalNoOfPackingGroup;

    @Column(name = "mix_part_type")
    private Long mixPartType;

    @Column(name = "mix_group")
    private Long mixGroup;

    @Column(name = "mix_box")
    private Long mixBox;

    @Column(name = "mix_layer")
    private Long mixLayer;

    @Column(name = "case_map")
    private Long caseMap;

    @Column(name = "images")
    private String images;

    @Column(name = "packed")
    private Boolean packed;

    @Column(name = "uploaded_image")
    private String uploadedImage;

    @ManyToOne(fetch = FetchType.EAGER) // Many BomTable can be created by one User
    @JoinColumn(name = "created_by", referencedColumnName = "user_id",nullable = false)
    @JsonBackReference
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER) // Many BomTable can be created by one User
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id",nullable = false)
    @JsonBackReference
    private User updatedBy;


    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at",nullable = false)
    private Date updatedAt;

    @Column(name = "upload_date", nullable = false)
    private Date uploadDate;

    @Column(name = "acknowledged_date")
    private Date acknowledgedDate;

    @Column(name = "quality_check_date")
    private Date qualityCheckDate;

    @Column(name = "partllabel_date")
    private Date partLabelDate;

    public Boolean getPacked() {
        return packed;
    }

    public void setPacked(Boolean packed) {
        this.packed = packed;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
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

    public BomTable getBomTable() {
        return bomTable;
    }

    public void setBomTable(BomTable bomTable) {
        this.bomTable = bomTable;
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

    public Long getTotalNoOfPackingGroup() {
        return totalNoOfPackingGroup;
    }

    public void setTotalNoOfPackingGroup(Long totalNoOfPackingGroup) {
        this.totalNoOfPackingGroup = totalNoOfPackingGroup;
    }

    public String getPackingGroup() {
        return packingGroup;
    }

    public void setPackingGroup(String packingGroup) {
        this.packingGroup = packingGroup;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getQtyRequired() {
        return qtyRequired;
    }

    public void setQtyRequired(Long qtyRequired) {
        this.qtyRequired = qtyRequired;
    }

    public Long getQtyPerLot() {
        return qtyPerLot;
    }

    public void setQtyPerLot(Long qtyPerLot) {
        this.qtyPerLot = qtyPerLot;
    }

    public String getPrimaryNo() {
        return primaryNo;
    }

    public void setPrimaryNo(String primaryNo) {
        this.primaryNo = primaryNo;
    }

    public Long getPackQty() {
        return packQty;
    }

    public void setPackQty(Long packQty) {
        this.packQty = packQty;
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

    public Integer getBomNo() {
        return bomNo;
    }

    public void setBomNo(Integer bomNo) {
        this.bomNo = bomNo;
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

    public void setUploadedImage(String uploadedImage) {
        this.uploadedImage = uploadedImage;
    }

    public Part() {
    }

    public Part(String partId, BomPart bomPart, User activeUser, long packingGroupIndex) {
        this.partId = partId;
        this.bomPartId = bomPart.getBomPartId();
        this.bomNo = bomPart.getBomNo();
        this.bomTable = bomPart.getBomTable();
        this.caseMap = bomPart.getCaseMap();
        this.catDescription = bomPart.getCatDescription();
        this.images = bomPart.getImages();
        this.mixBox = bomPart.getMixBox();
        this.mixLayer = bomPart.getMixLayer();
        this.mixGroup = bomPart.getMixGroup();
        this.mixPartType = bomPart.getMixPartType();
        this.packCode = bomPart.getPackCode();
        this.packQty = bomPart.getPackQty();
        this.packingGroup = bomPart.getPackingGroup();
        this.partDescription = bomPart.getPartDescription();
        this.partNo = bomPart.getPartNo();
        this.packingGroupIndex = packingGroupIndex;
        this.totalNoOfPackingGroup = bomPart.getTotalNoOfPackingGroup();
        this.qtyPerLot = bomPart.getQtyPerLot();
        this.qtyRequired = bomPart.getQtyRequired();
        this.version = bomPart.getVersion();
        this.validity = bomPart.getValidity();
        this.stLocation = bomPart.getStLocation();
        this.secondaryNo = bomPart.getSecondaryNo();
        this.primaryNo = bomPart.getLayerNo();
        this.layerNo = bomPart.getLayerNo();
        this.partType = bomPart.getPartType();
        this.uploadDate = bomPart.getUploadDate();
        this.acknowledgedDate = bomPart.getAcknowledgedDate();
        this.qualityCheckDate  = new Date();
        this.partLabelDate = bomPart.getPartLabelDate();
        this.updatedAt = new Date();
        this.createdAt = new Date();
        this.createdBy = activeUser;
        this.updatedBy = activeUser;
        this.packed = false;
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

    public long getMixPartType() {
        return mixPartType;
    }

    public void setMixPartType(long mixPartType) {
        this.mixPartType = mixPartType;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getAcknowledgedDate() {
        return acknowledgedDate;
    }

    public void setAcknowledgedDate(Date acknowledgedDate) {
        this.acknowledgedDate = acknowledgedDate;
    }

    public Date getQualityCheckDate() {
        return qualityCheckDate;
    }

    public void setQualityCheckDate(Date qualityCheckDate) {
        this.qualityCheckDate = qualityCheckDate;
    }

    public Date getPartLabelDate() {
        return partLabelDate;
    }

    public void setPartLabelDate(Date partLabelDate) {
        this.partLabelDate = partLabelDate;
    }

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getBomPartId() {
        return bomPartId;
    }

    public void setBomPartId(String bomPartId) {
        this.bomPartId = bomPartId;
    }

    public Long getPackingGroupIndex() {
        return packingGroupIndex;
    }

    public void setPackingGroupIndex(Long packingGroupIndex) {
        this.packingGroupIndex = packingGroupIndex;
    }

    public void setMixPartType(Long mixPartType) {
        this.mixPartType = mixPartType;
    }
}
