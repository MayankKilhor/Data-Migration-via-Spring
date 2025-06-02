package com.spaceage.logistics.Model.Postgres.Logs;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit_logs")
public class AuditLogs{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name="event_type")
    private String eventType; // Type of event (e.g., "UPDATE", "DELETE", "CREATE")

    @Column(name="entity_name")
    private String entityName; // Entity being modified (e.g., "Shipment", "Order")

    @Column(name="entity_id")
    private String entityId; // ID of the entity being modified

    @Column(name = "details")
    private String details;

    @Column(name="old_value")
    private String oldValue; // Old value (can be JSON or plain text)

    @Column(name="new_value")
    private String newValue; // New value (can be JSON or plain text)

    @Column(name = "ip_address")
    private String ipAddress; // NEW: Store IP Address

    @Column(name ="timestamp_gmt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampGmt; // Timestamp in GMT

//    @Column(name ="timestamp_ist")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date timestampIst; // Timestamp in IST

    // Constructors, Getters, Setters
    public AuditLogs() {}

    public AuditLogs(String username, String eventType, String entityName, String entityId, String details,
                    String oldValue, String newValue, Date timestampGmt,String ipAddress) {
        this.username = username;
        this.eventType = eventType;
        this.entityName = entityName;
        this.entityId = entityId;
        this.details = details;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.timestampGmt = timestampGmt;
        this.ipAddress = ipAddress;
    }

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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Date getTimestampGmt() {
        return timestampGmt;
    }

    public void setTimestampGmt(Date timestampGmt) {
        this.timestampGmt = timestampGmt;
    }

//    public Date getTimestampIst() {
//        return timestampIst;
//    }
//
//    public void setTimestampIst(Date timestampIst) {
//        this.timestampIst = timestampIst;
//    }
}
