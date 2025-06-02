//package com.spaceage.logistics.Model.Old.Core;
//
//
//import com.spaceage.logistics.Model.Old.Master.PackagingType;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "packaging")
//public class Packaging {
//
//    @Id
//    @Column(name = "packaging_id", nullable = false)
//    private String packaging_id;
//
//    @Column(name = "type", nullable = false)
//    private String type;
//
//    @Column(name = "material", nullable = false)
//    private String material;
//
//    @Column(name = "dimensions", nullable = false)
//    private String dimensions;
//    @Column(name = "weight", nullable = false)
//    private String weight;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "packaging_type_id", nullable = false, foreignKey = @ForeignKey(name = "fk_packaging_type"))
//    private PackagingType packagingType;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//    public String getPackaging_id() {
//        return packaging_id;
//    }
//
//    public void setPackaging_id(String packaging_id) {
//        this.packaging_id = packaging_id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getMaterial() {
//        return material;
//    }
//
//    public void setMaterial(String material) {
//        this.material = material;
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
//    public PackagingType getPackagingType() {
//        return packagingType;
//    }
//
//    public void setPackagingType(PackagingType packagingType) {
//        this.packagingType = packagingType;
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