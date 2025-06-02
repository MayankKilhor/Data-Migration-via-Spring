//package com.spaceage.logistics.Model.Old.Core;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "inventory")
//public class Inventory {
//
//    @Id
//    @Column(name = "inventory_id", nullable = false)
//    private String inventory_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "material_id", nullable = false, foreignKey = @ForeignKey(name = "fk_material"))
//    private Material material;
//
//    @Column(name = "quantity", nullable = false)
//    private Long quantity;
//    @Column(name = "location", nullable = false)
//    private String location;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "rack_id", nullable = false, foreignKey = @ForeignKey(name = "fk_storage_rack"))
//    private StorageRack storageRack;
//
//    //TODO why do we need bin(FK) in inventory when we already have it storage_rack
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "bin_id", nullable = false, foreignKey = @ForeignKey(name = "fk_storage_bin"))
//    private StorageBin storageBin;
//
//    @Column(name = "batch_number", nullable = false)
//    private Long batch_number;
//
//    @Column(name = "expiry_date", nullable = false)
//    private Date expiry_date;
//
//    @Column(name = "barcode", nullable = false)
//    private String barcode;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//    public String getInventory_id() {
//        return inventory_id;
//    }
//
//    public void setInventory_id(String inventory_id) {
//        this.inventory_id = inventory_id;
//    }
//
//    public Material getMaterial() {
//        return material;
//    }
//
//    public void setMaterial(Material material) {
//        this.material = material;
//    }
//
//    public Long getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Long quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public StorageRack getStorageRack() {
//        return storageRack;
//    }
//
//    public void setStorageRack(StorageRack storageRack) {
//        this.storageRack = storageRack;
//    }
//
//    public StorageBin getStorageBin() {
//        return storageBin;
//    }
//
//    public void setStorageBin(StorageBin storageBin) {
//        this.storageBin = storageBin;
//    }
//
//    public Long getBatch_number() {
//        return batch_number;
//    }
//
//    public void setBatch_number(Long batch_number) {
//        this.batch_number = batch_number;
//    }
//
//    public Date getExpiry_date() {
//        return expiry_date;
//    }
//
//    public void setExpiry_date(Date expiry_date) {
//        this.expiry_date = expiry_date;
//    }
//
//    public String getBarcode() {
//        return barcode;
//    }
//
//    public void setBarcode(String barcode) {
//        this.barcode = barcode;
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