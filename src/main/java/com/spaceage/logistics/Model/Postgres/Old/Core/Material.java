//package com.spaceage.logistics.Model.Old.Core;
//
//
//import com.spaceage.logistics.Model.Old.Master.MaterialType;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "material")
//public class Material {
//
//    @Id
//    @Column(name = "material_id", nullable = false)
//    private String material_id;
//
//    @Column(name = "name",nullable = false)
//    private String name;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "unit_of_measure",nullable = false)
//    private String unit_of_measure;
//
//    @Column(name = "barcode")
//    private String barcode;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "material_type_id", nullable = false, foreignKey = @ForeignKey(name = "fk_material_type"))
//    private MaterialType materialType;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//    public String getMaterial_id() {
//        return material_id;
//    }
//
//    public void setMaterial_id(String material_id) {
//        this.material_id = material_id;
//    }
//
//    public MaterialType getMaterialType() {
//        return materialType;
//    }
//
//    public void setMaterialType(MaterialType materialType) {
//        this.materialType = materialType;
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
//    public String getUnit_of_measure() {
//        return unit_of_measure;
//    }
//
//    public void setUnit_of_measure(String unit_of_measure) {
//        this.unit_of_measure = unit_of_measure;
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
