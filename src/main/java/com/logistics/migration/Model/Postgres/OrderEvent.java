package com.logistics.migration.Model.Postgres;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logistics.migration.Payload.enums.OrderEventStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_events")
public class OrderEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pallet_id", nullable = false)
    private String palletId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column
    private String location;

    @Column(nullable = false)
    private LocalDateTime eventTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderEventStatus status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_log_id", nullable = false)
    @JsonIgnore
    private OrderLog orderLog;

    // Constructors, Getters, and Setters

//    public OrderEvent(String palletId,String title, String description,OrderEventStatus status, LocalDateTime now) {
//        this.palletId = palletId;
//        this.title = title;
//        this.description = description;
//        this.status = status;
//        this.eventTime = now;
//    }


    public OrderEvent() {
    }

    public OrderEvent(String palletId, String title, String description, String location, OrderEventStatus status, LocalDateTime eventTime) {
        this.palletId = palletId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.status = status;
        this.eventTime = eventTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public OrderLog getOrderLog() {
        return orderLog;
    }

    public void setOrderLog(OrderLog orderLog) {
        this.orderLog = orderLog;
    }

    public String getPalletId() {
        return palletId;
    }

    public void setPalletId(String palletId) {
        this.palletId = palletId;
    }

    public OrderEventStatus getStatus() {
        return status;
    }

    public void setStatus(OrderEventStatus status) {
        this.status = status;
    }
}
