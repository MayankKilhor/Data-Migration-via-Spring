package com.logistics.migration.Model.Postgres;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.logistics.migration.Model.Postgres.Security.User;
import com.logistics.migration.Model.Postgres.Shipping.ReceipentInfo;
import com.logistics.migration.Model.Postgres.Shipping.ShippingTruck;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pallet")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pallet {

    @Id
    @Column(name = "pallet_id", nullable = false)
    private String palletId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "fk_packagingOrder"))
    @JsonBackReference("pallet")
    private PackagingOrder packagingOrder;

    @Column(name = "packing_group")
    private String packingGroup;

    @Column(name = "secondary_no")
    private String secondaryNo;

    @OneToMany(mappedBy = "pallet", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Part> partList;

    @OneToMany(mappedBy = "pallet", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Box> boxList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receipent_id", referencedColumnName = "receipent_id", foreignKey = @ForeignKey(name = "fk_pallet_receipent"))
    @JsonBackReference
    private ReceipentInfo receipentInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id", referencedColumnName = "truck_id", foreignKey = @ForeignKey(name = "fk_shipping_truck"))
    private ShippingTruck truckInfo;

    @Column(name = "part_count", nullable = false)
    private Long partCount;

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
    public Pallet() {}

    // --- Getters & Setters ---
    public String getPalletId() {
        return palletId;
    }

    public void setPalletId(String palletId) {
        this.palletId = palletId;
    }

    public PackagingOrder getPackagingOrder() {
        return packagingOrder;
    }

    public void setPackagingOrder(PackagingOrder packagingOrder) {
        this.packagingOrder = packagingOrder;
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

    public List<Part> getPartList() {
        return partList;
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<Box> boxList) {
        this.boxList = boxList;
    }

    public ReceipentInfo getReceipentInfo() {
        return receipentInfo;
    }

    public void setReceipentInfo(ReceipentInfo receipentInfo) {
        this.receipentInfo = receipentInfo;
    }

    public ShippingTruck getTruckInfo() {
        return truckInfo;
    }

    public void setTruckInfo(ShippingTruck truckInfo) {
        this.truckInfo = truckInfo;
    }

    public Long getPartCount() {
        return partCount;
    }

    public void setPartCount(Long partCount) {
        this.partCount = partCount;
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
}
