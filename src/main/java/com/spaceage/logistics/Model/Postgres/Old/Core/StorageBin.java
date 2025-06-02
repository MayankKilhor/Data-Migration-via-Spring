//package com.spaceage.logistics.Model.Old.Core;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "storage_bin")
//public class StorageBin {
//
//    @Id
//    @Column(name = "bin_id", nullable = false)
//    private String bin_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "rack_id", nullable = false, foreignKey = @ForeignKey(name = "fk_storage_rack"))
//    private StorageRack storageRack;
//
//    @Column(name = "name",nullable = false)
//    private String name;
//
//    @Column(name = "capacity", nullable = false)
//    private Long capacity;
//
//    @Column(name = "current_load", nullable = false)
//    private Long current_load;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//    public String getBin_id() {
//        return bin_id;
//    }
//
//    public void setBin_id(String bin_id) {
//        this.bin_id = bin_id;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Long getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(Long capacity) {
//        this.capacity = capacity;
//    }
//
//    public Long getCurrent_load() {
//        return current_load;
//    }
//
//    public void setCurrent_load(Long current_load) {
//        this.current_load = current_load;
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
