//package com.spaceage.logistics.Model.Old.Mapping;
//
//
//import com.spaceage.logistics.Model.Old.Core.Inventory;
//import com.spaceage.logistics.Model.Old.Core.Pallet;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "pallet_inventory")
//public class PalletInventory {
//
//    @Id
//    @Column(name = "pallet_inventory_id", nullable = false)
//    private String pallet_inventory_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pallet_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pallet"))
//    private Pallet pallet;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "inventory_id", nullable = false, foreignKey = @ForeignKey(name = "fk_inventory"))
//    private Inventory inventory;
//
//    @Column(name = "quantity", nullable = false)
//    private Long quantity;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//
//    public String getPallet_inventory_id() {
//        return pallet_inventory_id;
//    }
//
//    public void setPallet_inventory_id(String pallet_inventory_id) {
//        this.pallet_inventory_id = pallet_inventory_id;
//    }
//
//    public Pallet getPallet() {
//        return pallet;
//    }
//
//    public void setPallet(Pallet pallet) {
//        this.pallet = pallet;
//    }
//
//    public Inventory getInventory() {
//        return inventory;
//    }
//
//    public void setInventory(Inventory inventory) {
//        this.inventory = inventory;
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