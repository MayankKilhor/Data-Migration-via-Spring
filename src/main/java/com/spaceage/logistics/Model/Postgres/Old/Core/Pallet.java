//package com.spaceage.logistics.Model.Old.Core;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "pallet")
//public class Pallet {
//
//    @Id
//    @Column(name = "pallet_number", nullable = false)
//    private String pallet_number;
//
//    @Column(name = "dimensions", nullable = false)
//    private String dimensions;
//    @Column(name = "weight", nullable = false)
//    private String weight;
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
//    public String getPallet_number() {
//        return pallet_number;
//    }
//
//    public void setPallet_number(String pallet_number) {
//        this.pallet_number = pallet_number;
//    }
//
//    public String getDimensions() {
//        return dimensions;
//    }
//
//    public void setDimensions(String dimensions) {
//        this.dimensions = dimensions;
//    }
//
//    public String getWeight() {
//        return weight;
//    }
//
//    public void setWeight(String weight) {
//        this.weight = weight;
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