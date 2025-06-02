package com.logistics.migration.Model.Postgres.Uploading;


import com.fasterxml.jackson.annotation.*;


import com.logistics.migration.Model.Postgres.PackagingOrder;
import com.logistics.migration.Model.Postgres.Part;
import com.logistics.migration.Model.Postgres.Security.User;
import com.logistics.migration.Payload.enums.*;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"bomPartList", "partList", "packagingOrder"})
@Entity
@Table(name = "bom_table")
public class BomTable {

    @Id
    @Column(name = "bomtable_id",nullable = false)
    private String bomTableId;


    @Column(name = "lot_ref_no",nullable = false,unique = true)
    private String lotRefNo;

    @Column(name = "part_count",nullable = false)
    private Long partCount;

    @Column(name = "mirn_part_count",nullable = false)
    private Long mirnPartCount;

    @Column(name = "pending_for_pickup_part_count",nullable = false)
    private Long pendingForPickupPartCount;

    @Column(name = "acknowledged_part_count",nullable = false)
    private Long acknowledgedPartCount;

    @Column(name = "qc_failed_part_count",nullable = false)
    private Long qcFailedPartCount;

    @Column(name = "partlabel_part_count",nullable = false)
    private Long partlabelPartCount;

    @Column(name = "bomcomplete_part_count",nullable = false)
    private Long bomcompletePartCount;

    @Column(name = "error_part_count",nullable = false)
    private Long errorPartCount;

    @Column(name="s3_loc")
    private String s3Location;

    @Column(name="s3_key")
    private String s3Key;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id",nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
//    @JsonBackReference
//    private User user;



    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id", foreignKey = @ForeignKey(name = "fk_status_bom"))
    @JsonBackReference
    private BomUploadStatus uploadStatus;

    @OneToOne(mappedBy = "bomTable", fetch = FetchType.LAZY)
    @JsonManagedReference
    private PackagingOrder packagingOrder;




    @OneToMany(mappedBy = "bomTable", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonManagedReference("bomParts")  // Add a specific name to match the reference in BomPart
    private List<BomPart> bomPartList;

    @OneToMany(mappedBy = "bomTable", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonManagedReference("parts")  // Add a specific name to match the reference in BomPart
    private List<Part> partList;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BomTableStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "acknowledgement_status", nullable = false)
    private BomAcknowledgementStatus acknowledgementStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "quality_check_status", nullable = false)
    private BomQualityCheckStatus qualityCheckStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "part_label_status", nullable = false)
    private BomPartLabelStatus partLabelStatus;

    @Column(name = "mirn_url")
    private String MIRN_Url;

    @Column(name = "quality_check_url")
    private String qualityCheckUrl;

    @Column(name = "partlabel_url")
    private String partLabelUrl;

    @Column(name = "lot_size",nullable = false)
    private Long lotSize;

    @Column(name = "container_count")
    private Long containerCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model", referencedColumnName = "model_id",nullable = false)
    @JsonBackReference
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project", referencedColumnName = "project_id",nullable = false)
    @JsonBackReference
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_customer", referencedColumnName = "end_customer_id",nullable = false)
    @JsonBackReference
    private EndCustomer endCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_customer", referencedColumnName = "origin_customer_id",nullable = false)
    @JsonBackReference
    private OriginCustomer originCustomer;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_loc",nullable = false)
    private ShippingLoc shippingLoc;

    @ManyToOne(fetch = FetchType.LAZY) // Many BomTable can be created by one User
    @JoinColumn(name = "created_by", referencedColumnName = "user_id",nullable = false)
    @JsonBackReference
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY) // Many BomTable can be created by one User
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id",nullable = false)
    @JsonBackReference
    private User updatedBy;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at",nullable = false)
    private Date updatedAt;

    public BomTable(String bomTableId, String lotRefNo,Long partCount, String s3Key, String s3Location, User user, Date date, Project project, Model model, OriginCustomer originCustomer, EndCustomer endCustomer,Long lotSize, Long containerCount,ShippingLoc shippingLoc,  BomTableStatus bomTableStatus,BomAcknowledgementStatus acknowledgementStatus, BomQualityCheckStatus bomQualityCheckStatus, BomPartLabelStatus bomPartLabelStatus, BomUploadStatus bomUploadStatus) {
        this.bomTableId = bomTableId;
        this.partCount = partCount;
        this.s3Key = s3Key;
        this.lotRefNo = lotRefNo;
        this.s3Location = s3Location;
        this.createdAt = date;
        this.updatedAt = date;
        this.model = model;
        this.project = project;
        this.originCustomer = originCustomer;
        this.endCustomer = endCustomer;
        this.lotSize = lotSize;
        this.containerCount = containerCount;
        this.shippingLoc = shippingLoc;
        this.status = bomTableStatus;
        this.acknowledgementStatus = acknowledgementStatus;
        this.qualityCheckStatus = bomQualityCheckStatus;
        this.partLabelStatus = bomPartLabelStatus;
        this.uploadStatus = bomUploadStatus;
        this.createdBy = user;
        this.updatedBy = user;
        this.mirnPartCount = 0L;
        this.pendingForPickupPartCount = 0L;
        this.acknowledgedPartCount = 0L;
        this.qcFailedPartCount = 0L;
        this.partlabelPartCount = 0L;
        this.bomcompletePartCount = 0L;
        this.errorPartCount = 0L;
    }

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
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




    public String getLotRefNo() {
        return lotRefNo;
    }

    public void setLotRefNo(String lotRefNo) {
        this.lotRefNo = lotRefNo;
    }

    public String getS3Location() {
        return s3Location;
    }

    public void setS3Location(String s3Location) {
        this.s3Location = s3Location;
    }




    public List<BomPart> getBomPartList() {
        return bomPartList;
    }

    public void setBomPartList(List<BomPart> bomPartList) {
        this.bomPartList = bomPartList;
    }




//    public BomTable(String bomTableId, String s3key,Long partCount, String s3Location, User user, Date createdAt, BomTableStatus status, BomQualityCheckStatus qualityCheckStatus, BomPartLabelStatus partLabelStatus, BomUploadStatus uploadStatus) {
//        this.bomTableId = bomTableId;
//        this.s3Key = s3key;
//        this.s3Location = s3Location;
//        this.user = user;
//        this.createdAt = createdAt;
//        this.status = status;
//        this.qualityCheckStatus = qualityCheckStatus;
//        this.partLabelStatus = partLabelStatus;
//        this.uploadStatus = uploadStatus;
//    }


    public BomTable() {
    }

    public BomTableStatus getStatus() {
        return status;
    }

    public void setStatus(BomTableStatus status) {
        this.status = status;
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

    public String getS3Key() {
        return s3Key;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }

    public BomUploadStatus getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(BomUploadStatus uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public BomQualityCheckStatus getQualityCheckStatus() {
        return qualityCheckStatus;
    }

    public void setQualityCheckStatus(BomQualityCheckStatus quality_check_status) {
        this.qualityCheckStatus = quality_check_status;
    }

    public ShippingLoc getShippingLoc() {
        return shippingLoc;
    }

    public void setShippingLoc(ShippingLoc shippingLoc) {
        this.shippingLoc = shippingLoc;
    }

    public BomPartLabelStatus getPartLabelStatus() {
        return partLabelStatus;
    }

    public void setPartLabelStatus(BomPartLabelStatus partLabelStatus) {
        this.partLabelStatus = partLabelStatus;
    }

    public List<Part> getPartList() {
        return partList;
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }

    public Long getPartCount() {
        return partCount;
    }

    public void setPartCount(Long partCount) {
        this.partCount = partCount;
    }

    public PackagingOrder getPackagingOrder() {
        return packagingOrder;
    }

    public void setPackagingOrder(PackagingOrder packagingOrder) {
        this.packagingOrder = packagingOrder;
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

    public BomAcknowledgementStatus getAcknowledgementStatus() {
        return acknowledgementStatus;
    }

    public void setAcknowledgementStatus(BomAcknowledgementStatus acknowledgementStatus) {
        this.acknowledgementStatus = acknowledgementStatus;
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public EndCustomer getEndCustomer() {
        return endCustomer;
    }

    public void setEndCustomer(EndCustomer endCustomer) {
        this.endCustomer = endCustomer;
    }

    public OriginCustomer getOriginCustomer() {
        return originCustomer;
    }

    public void setOriginCustomer(OriginCustomer originCustomer) {
        this.originCustomer = originCustomer;
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
}

