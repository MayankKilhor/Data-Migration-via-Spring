package com.spaceage.logistics.Model.Postgres;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import com.spaceage.logistics.Model.Postgres.Security.User;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "box")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Box {

    @Id
    @Column(name = "box_id", nullable = false)
    private String boxId;

    @OneToMany(mappedBy = "box", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Part> partList;

    @Column(name = "part_count", nullable = false)
    private Long partCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pallet_id", foreignKey = @ForeignKey(name = "fk_box_pallet"))
    @JsonBackReference
    private Pallet pallet;

    @Column(name = "packing_group")
    private String packingGroup;

    @Column(name = "secondary_no")
    private String secondaryNo;

    @Column(name = "primary_no")
    private String primaryNo;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by", referencedColumnName = "user_id", nullable = false)
    @JsonBackReference
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id", nullable = false)
    @JsonBackReference
    private User updatedBy;

    // --- Constructors ---
    public Box() {}

    // --- Getters & Setters ---
    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
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

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
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

    public String getPackingGroup() {
        return packingGroup;
    }

    public void setPackingGroup(String packingGroup) {
        this.packingGroup = packingGroup;
    }

    public String getSecondaryNo() {
        return secondaryNo;
    }

    public void setSecondaryNo(String secondaryNo) {
        this.secondaryNo = secondaryNo;
    }

    public String getPrimaryNo() {
        return primaryNo;
    }

    public void setPrimaryNo(String primaryNo) {
        this.primaryNo = primaryNo;
    }
}
