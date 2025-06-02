//package com.spaceage.logistics.Model.Old.Master;
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "order_status")
//public class OrderStatus {
//
//    @Id
//    @Column(name = "status_id", nullable = false)
//    private String status_id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//    public String getStatus_id() {
//        return status_id;
//    }
//
//    public void setStatus_id(String status_id) {
//        this.status_id = status_id;
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
