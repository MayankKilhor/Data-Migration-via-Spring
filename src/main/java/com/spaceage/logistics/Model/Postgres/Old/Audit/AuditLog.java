//package com.spaceage.logistics.Model.Old.Audit;
//
//
//import com.spaceage.logistics.Model.Postgres.Security.User;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "audit_log")
//public class AuditLog {
//
//    @Id
//    @Column(name = "audit_log_id", nullable = false)
//    private String audit_log_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
//    private User user;
//
//    @Column(name = "action", nullable = false)
//    private String action;
//
//    @Column(name = "table_name", nullable = false)
//    private String table_name;
//
//    @Column(name = "record_id", nullable = false)
//    private Long record_id;
//
//    @Column(name = "details", nullable = false)
//    private String details;
//
//    @Column(name = "timestamp", nullable = false)
//    private Date timestamp;
//
//    public String getAudit_log_id() {
//        return audit_log_id;
//    }
//
//    public void setAudit_log_id(String audit_log_id) {
//        this.audit_log_id = audit_log_id;
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
//    public String getAction() {
//        return action;
//    }
//
//    public void setAction(String action) {
//        this.action = action;
//    }
//
//    public String getTable_name() {
//        return table_name;
//    }
//
//    public void setTable_name(String table_name) {
//        this.table_name = table_name;
//    }
//
//    public Long getRecord_id() {
//        return record_id;
//    }
//
//    public void setRecord_id(Long record_id) {
//        this.record_id = record_id;
//    }
//
//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
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