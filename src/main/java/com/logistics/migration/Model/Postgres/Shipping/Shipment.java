package com.logistics.migration.Model.Postgres.Shipping;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @Column(name = "shipment_id", nullable = false)
    private String shipment_id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "fk_order"))
//    private Order order;

    @Column(name = "shipment_date")
    private Date shipment_date;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "tracking_number")
    private Long tracking_number;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    public String getShipment_id() {
        return shipment_id;
    }

    public void setShipment_id(String shipment_id) {
        this.shipment_id = shipment_id;
    }


    public Date getShipment_date() {
        return shipment_date;
    }

    public void setShipment_date(Date shipment_date) {
        this.shipment_date = shipment_date;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Long getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(Long tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Shipment(String shipment_id, Date created_at) {
        this.shipment_id = shipment_id;
        this.created_at = created_at;
    }

    public Shipment() {
    }
}
