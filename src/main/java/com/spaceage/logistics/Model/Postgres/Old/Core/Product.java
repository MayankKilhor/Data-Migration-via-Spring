//package com.spaceage.logistics.Model.Old.Core;
//
//
//
//import com.spaceage.logistics.Model.Old.Master.ProductCategory;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "product")
//public class Product {
//
//    @Id
//    @Column(name = "product_id", nullable = false)
//    private String product_id;
//
//    @Column(name = "name",nullable = false)
//    private String name;
//
//    @Column(name = "description")
//    private String description;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product_category"))
//    private ProductCategory productCategory;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//
//    public String getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(String product_id) {
//        this.product_id = product_id;
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
//    public ProductCategory getProductCategory() {
//        return productCategory;
//    }
//
//    public void setProductCategory(ProductCategory productCategory) {
//        this.productCategory = productCategory;
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
