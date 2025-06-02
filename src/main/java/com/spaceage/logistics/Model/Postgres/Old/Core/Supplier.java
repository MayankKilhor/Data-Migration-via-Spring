//package com.spaceage.logistics.Model.Old.Core;
//
//
//import com.spaceage.logistics.Model.Old.Master.SupplierType;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "supplier")
//public class Supplier {
//
//    @Id
//    @Column(name = "supplier_id", nullable = false)
//    private String supplier_id;
//
//    @Column(name = "name",nullable = false)
//    private String name;
//
//    @Column(name = "description")
//    private String description;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "supplier_type_id", nullable = false, foreignKey = @ForeignKey(name = "fk_supplier_type"))
//    private SupplierType supplierType;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//
//    public String getSupplier_id() {
//        return supplier_id;
//    }
//
//    public void setSupplier_id(String supplier_id) {
//        this.supplier_id = supplier_id;
//    }
//
//    public SupplierType getSupplierType() {
//        return supplierType;
//    }
//
//    public void setSupplierType(SupplierType supplierType) {
//        this.supplierType = supplierType;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(Date created_at) {
//        this.created_at = created_at;
//    }
//
//    public Date getUpdated_at() {
//        return updated_at;
//    }
//
//    public void setUpdated_at(Date updated_at) {
//        this.updated_at = updated_at;
//    }
//}
