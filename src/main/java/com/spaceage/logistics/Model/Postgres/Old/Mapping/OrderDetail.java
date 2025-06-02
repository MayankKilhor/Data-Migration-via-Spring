//package com.spaceage.logistics.Model.Old.Mapping;
//
//
//import com.spaceage.logistics.Model.Old.Core.Order;
//import com.spaceage.logistics.Model.Old.Core.Product;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "order_detail")
//public class OrderDetail {
//
//    @Id
//    @Column(name = "order_detail_id", nullable = false)
//    private String order_detail_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "fk_order"))
//    private Order order;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product"))
//    private Product product;
//
//    @Column(name = "quantity", nullable = false)
//    private Long quantity;
//
//    @Column(name = "unit_price", nullable = false)
//    private Long unit_price;
//
//    public String getOrder_detail_id() {
//        return order_detail_id;
//    }
//
//    public void setOrder_detail_id(String order_detail_id) {
//        this.order_detail_id = order_detail_id;
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
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
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
//    public Long getUnit_price() {
//        return unit_price;
//    }
//
//    public void setUnit_price(Long unit_price) {
//        this.unit_price = unit_price;
//    }
//}