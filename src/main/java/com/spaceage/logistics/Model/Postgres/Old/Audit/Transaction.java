//package com.spaceage.logistics.Model.Old.Audit;
//
//
//import com.spaceage.logistics.Model.Old.Core.Inventory;
//import com.spaceage.logistics.Model.Postgres.Security.User;
//import com.spaceage.logistics.Model.Old.Master.TransactionType;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "transaction")
//public class Transaction {
//
//    @Id
//    @Column(name = "transaction_id", nullable = false)
//    private String transaction_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "inventory_id", nullable = false, foreignKey = @ForeignKey(name = "fk_inventory"))
//    private Inventory inventory;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "transaction_type_id", nullable = false, foreignKey = @ForeignKey(name = "fk_transaction_type"))
//    private TransactionType transactionType;
//
//    @Column(name = "quantity", nullable = false)
//    private Long quantity;
//
//    @Column(name = "timestamp", nullable = false)
//    private Date timestamp;
//
//    public String getTransaction_id() {
//        return transaction_id;
//    }
//
//    public void setTransaction_id(String transaction_id) {
//        this.transaction_id = transaction_id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
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
//    public TransactionType getTransactionType() {
//        return transactionType;
//    }
//
//    public void setTransactionType(TransactionType transactionType) {
//        this.transactionType = transactionType;
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
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
//}