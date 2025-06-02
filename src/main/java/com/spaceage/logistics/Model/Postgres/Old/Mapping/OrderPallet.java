//package com.spaceage.logistics.Model.Old.Mapping;
//
//
//
//import com.spaceage.logistics.Model.Old.Core.Order;
//import com.spaceage.logistics.Model.Old.Core.Pallet;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "order_pallet")
//public class OrderPallet {
//
//    @Id
//    @Column(name = "order_pallet_id", nullable = false)
//    private String order_pallet_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "fk_order"))
//    private Order order;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pallet_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pallet"))
//    private Pallet pallet;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//    public String getOrder_pallet_id() {
//        return order_pallet_id;
//    }
//
//    public void setOrder_pallet_id(String order_pallet_id) {
//        this.order_pallet_id = order_pallet_id;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
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