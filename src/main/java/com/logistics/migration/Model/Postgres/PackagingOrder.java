package com.logistics.migration.Model.Postgres;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.logistics.migration.Model.Postgres.Uploading.BomTable;
import com.logistics.migration.Payload.enums.PackagingOrderStatus;
import com.logistics.migration.Payload.enums.ShippingLoc;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "packaging_order")
public class PackagingOrder {
    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipping")
    private ShippingLoc shipping;

    @OneToMany(mappedBy = "packagingOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("pallet")  // Add a specific name to match the reference in BomPart
    private List<Pallet> palletList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bomtable_id", referencedColumnName = "bomtable_id", nullable = false, foreignKey = @ForeignKey(name = "fk_bom_table"))
    @JsonBackReference
    @JsonIgnore
    private BomTable bomTable;

    @OneToOne(mappedBy = "packagingOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private OrderLog orderLog;


    @Column(name = "pallet_count",nullable = false)
    private Long palletCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PackagingOrderStatus status;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public ShippingLoc getShipping() {
        return shipping;
    }

    public void setShipping(ShippingLoc shipping) {
        this.shipping = shipping;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Pallet> getPalletList() {
        return palletList;
    }

    public void setPalletList(List<Pallet> palletList) {
        this.palletList = palletList;
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

    public Long getPalletCount() {
        return palletCount;
    }

    public void setPalletCount(Long palletCount) {
        this.palletCount = palletCount;
    }

    public BomTable getBomTable() {
        return bomTable;
    }

    public void setBomTable(BomTable bomTable) {
        this.bomTable = bomTable;
    }

    public PackagingOrderStatus getStatus() {
        return status;
    }

    public void setStatus(PackagingOrderStatus status) {
        this.status = status;
    }

    public OrderLog getOrderLog() {
        return orderLog;
    }

    public void setOrderLog(OrderLog orderLog) {
        this.orderLog = orderLog;
    }
}
