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
//@Table(name = "material_type")
//public class MaterialType {
//
//    @Id
//    @Column(name = "material_type_id", nullable = false)
//    private String material_type_id;
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
//    public String getMaterial_type_id() {
//        return material_type_id;
//    }
//
//    public void setMaterial_type_id(String material_type_id) {
//        this.material_type_id = material_type_id;
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
