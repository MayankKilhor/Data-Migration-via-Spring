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
//@Table(name = "product_category")
//public class ProductCategory {
//
//    @Id
//    @Column(name = "category_id", nullable = false)
//    private String category_id;
//
//    @Column(name = "name",nullable = false)
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
//    public String getCategory_id() {
//        return category_id;
//    }
//
//    public void setCategory_id(String category_id) {
//        this.category_id = category_id;
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
