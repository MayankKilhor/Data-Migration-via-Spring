package com.spaceage.logistics.Model.Postgres.Uploading;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spaceage.logistics.Payload.enums.BomPartStatus;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bom_part")
public class BomPart {

    @Id
    @Column(name = "bom_part_id",nullable = false)
    private String bomPartId;

    @Column(name = "bom_no")
    private Integer bomNo;

    @Column(name = "part_no")
    private String partNo;

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
    @JsonBackReference("bomParts")
    private BomTable bomTable;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BomPartStatus status;

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

    @Column(name = "mix_part_type")
    private long mixPartType;

    @Column(name = "pack_code")
    private String packCode;

    @Column(name = "pack_qty")
    private Long packQty;

    @Column(name = "packing_group")
    private String packingGroup;

    @Column(name = "total_no_of_packing_group")
    private Long totalNoOfPackingGroup;

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

    @Column(name = "quality_check")
    private Boolean qualityCheck;

    @Column(name = "reason_for_quality_check")
    private String reason;

    @Column(name = "upload_date", nullable = false)
    private Date uploadDate;

    @Column(name = "acknowledged_date")
    private Date acknowledgedDate;

    @Column(name = "quality_check_date")
    private Date qualityCheckDate;

    @Column(name = "partllabel_date")
    private Date partLabelDate;


    public String getBomPartId() {
        return bomPartId;
    }

    public void setBomPartId(String bomPartId) {
        this.bomPartId = bomPartId;
    }

    public BomTable getBomTable() {
        return bomTable;
    }

    public void setBomTable(BomTable bomTable) {
        this.bomTable = bomTable;
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

    public Long getTotalNoOfPackingGroup() {
        return totalNoOfPackingGroup;
    }

    public void setTotalNoOfPackingGroup(Long totalNoOfPackingGroup) {
        this.totalNoOfPackingGroup = totalNoOfPackingGroup;
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

    public Boolean getQualityCheck() {
        return qualityCheck;
    }

    public void setQualityCheck(Boolean qualityCheck) {
        this.qualityCheck = qualityCheck;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BomPartStatus getStatus() {
        return status;
    }

    public void setStatus(BomPartStatus status) {
        this.status = status;
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
}
