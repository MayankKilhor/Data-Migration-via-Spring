//package com.spaceage.logistics.Model.Old.Core;
//
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "storage_rack")
//public class StorageRack {
//
//    @Id
//    @Column(name = "rack_id", nullable = false)
//    private String rack_id;
//
//    @Column(name = "name",nullable = false)
//    private String name;
//
//    @Column(name = "location")
//    private String location;
//
//    @Column(name = "capacity", nullable = false)
//    private Long capacity;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//
//    public String getRack_id() {
//        return rack_id;
//    }
//
//    public void setRack_id(String rack_id) {
//        this.rack_id = rack_id;
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
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
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
