//package com.spaceage.logistics.Model.Old.Mapping;
//
//
//import com.spaceage.logistics.Model.Old.Core.Material;
//import com.spaceage.logistics.Model.Old.Core.Product;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "product_material")
//public class ProductMaterial {
//
//    @Id
//    @Column(name = "product_material_id", nullable = false)
//    private String product_material_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product"))
//    private Product product;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "material_id", nullable = false, foreignKey = @ForeignKey(name = "fk_material"))
//    private Material material;
//
//    @Column(name = "quantity", nullable = false)
//    private Long quantity;
//
//    @Column(name = "batch_number", nullable = false)
//    private Long batch_number;
//
//    @Column(name = "barcode",nullable = false)
//    private String barcode;
//
//    public String getProduct_material_id() {
//        return product_material_id;
//    }
//
//    public void setProduct_material_id(String product_material_id) {
//        this.product_material_id = product_material_id;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
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
//    public Long getBatch_number() {
//        return batch_number;
//    }
//
//    public void setBatch_number(Long batch_number) {
//        this.batch_number = batch_number;
//    }
//
//    public String getBarcode() {
//        return barcode;
//    }
//
//    public void setBarcode(String barcode) {
//        this.barcode = barcode;
//    }
//}