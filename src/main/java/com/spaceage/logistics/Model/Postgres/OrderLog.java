package com.spaceage.logistics.Model.Postgres;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_logs")
public class OrderLog {

    @Id
    private String id;

    @OneToOne
    @MapsId // Ensures the primary key is shared with PackagingOrder
    @JsonBackReference
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_order_log_packaging_order"))
    private PackagingOrder packagingOrder;


    @OneToMany(mappedBy = "orderLog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderEvent> events = new ArrayList<>();


    public OrderLog() {
    }

    public PackagingOrder getPackagingOrder() {
        return packagingOrder;
    }

    public void setPackagingOrder(PackagingOrder packagingOrder) {
        this.packagingOrder = packagingOrder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public List<OrderEvent> getEvents() {
        return events;
    }

    public void setEvents(List<OrderEvent> events) {
        this.events = events;
    }

    public void addEvent(OrderEvent event) {
        event.setOrderLog(this);
        this.events.add(event);
    }

    public void removeEvent(OrderEvent event) {
        event.setOrderLog(null);
        this.events.remove(event);
    }
}
