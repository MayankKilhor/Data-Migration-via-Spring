//package com.spaceage.logistics.Model.Old.Audit;
//
//
//import com.spaceage.logistics.Model.Old.Core.Inventory;
//import com.spaceage.logistics.Model.Postgres.Security.User;
//import com.spaceage.logistics.Model.Old.Master.QualityAuditResult;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "quality_audit")
//public class QualityAudit {
//
//    @Id
//    @Column(name = "quality_audit_id", nullable = false)
//    private String quality_audit_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "inventory_id", nullable = false, foreignKey = @ForeignKey(name = "fk_inventory"))
//    private Inventory inventory;
//
//    @Column(name = "audit_date", nullable = false)
//    private Date audit_date;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_auditor_id"))
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "result_id", nullable = false, foreignKey = @ForeignKey(name = "fk_result_id"))
//    private QualityAuditResult qualityAuditResult;
//
//    @Column(name = "remarks", nullable = false)
//    private String remarks;
//
//    @Column(name = "created_at", nullable = false)
//    private Date created_at;
//
//    @Column(name = "updated_at")
//    private Date updated_at;
//
//    public String getQuality_audit_id() {
//        return quality_audit_id;
//    }
//
//    public void setQuality_audit_id(String quality_audit_id) {
//        this.quality_audit_id = quality_audit_id;
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
//    public Date getAudit_date() {
//        return audit_date;
//    }
//
//    public void setAudit_date(Date audit_date) {
//        this.audit_date = audit_date;
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
//    public QualityAuditResult getQualityAuditResult() {
//        return qualityAuditResult;
//    }
//
//    public void setQualityAuditResult(QualityAuditResult qualityAuditResult) {
//        this.qualityAuditResult = qualityAuditResult;
//    }
//
//    public String getRemarks() {
//        return remarks;
//    }
//
//    public void setRemarks(String remarks) {
//        this.remarks = remarks;
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