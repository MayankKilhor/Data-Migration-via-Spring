//package com.spaceage.logistics.Model.Old.Core;
//
//
//
//import com.spaceage.logistics.Model.Old.Master.OrderStatus;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @Column(name = "order_id", nullable = false)
//    private String order_id;
//
//    @Column(name = "customer_id", nullable = false)
//    private Long customer_id;
//
//    @Column(name = "order_date", nullable = false)
//    private Date order_date;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "status_id", nullable = false, foreignKey = @ForeignKey(name = "fk_order_status"))
//    private OrderStatus orderStatus;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//    public String getOrder_id() {
//        return order_id;
//    }
//
//    public void setOrder_id(String order_id) {
//        this.order_id = order_id;
//    }
//
//    public Long getCustomer_id() {
//        return customer_id;
//    }
//
//    public void setCustomer_id(Long customer_id) {
//        this.customer_id = customer_id;
//    }
//
//    public Date getOrder_date() {
//        return order_date;
//    }
//
//    public void setOrder_date(Date order_date) {
//        this.order_date = order_date;
//    }
//
//    public OrderStatus getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(OrderStatus orderStatus) {
//        this.orderStatus = orderStatus;
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
