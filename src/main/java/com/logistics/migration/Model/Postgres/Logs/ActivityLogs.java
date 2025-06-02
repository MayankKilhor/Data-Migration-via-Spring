package com.logistics.migration.Model.Postgres.Logs;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "activity_logs")
public class ActivityLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name="entity_name")
    private String entityName; // Entity being modified (e.g., "Shipment", "Order")

    @Column(name="entity_id")
    private String entityId; // ID of the entity being modified

    @Column(name="event_type")
    private String eventType;

    @Column(name = "details")
    private String details;

    @Column(name = "ip_address")
    private String ipAddress; // NEW: Store IP Address

    @Column(name ="timestamp_gmt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampGmt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTimestampGmt() {
        return timestampGmt;
    }

    public void setTimestampGmt(Date timestampGmt) {
        this.timestampGmt = timestampGmt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }


    public ActivityLogs(String username, String entityName, String entityId, String eventType, String details, String ipAddress, Date timestampGmt) {
        this.username = username;
        this.entityName = entityName;
        this.entityId = entityId;
        this.eventType = eventType;
        this.details = details;
        this.ipAddress = ipAddress;
        this.timestampGmt = timestampGmt;
    }
}
