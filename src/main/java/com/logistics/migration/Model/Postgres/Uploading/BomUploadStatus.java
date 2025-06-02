package com.logistics.migration.Model.Postgres.Uploading;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "bom_table_upload_status")
public class BomUploadStatus {
    @Id
    @Column(name = "status_id", nullable = false)
    private String statusId;

    @OneToOne(mappedBy = "uploadStatus", fetch = FetchType.LAZY)
    @JsonIgnore
    private BomTable bomTable;

    @Column(name ="uploaded",nullable = false)
    private Boolean uploaded;

    @Column(name="percentage",nullable = false)
    private int percentage;

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public BomTable getBomTable() {
        return bomTable;
    }

    public void setBomTable(BomTable bomTable) {
        this.bomTable = bomTable;
    }

    public Boolean getUploaded() {
        return uploaded;
    }

    public void setUploaded(Boolean uploaded) {
        this.uploaded = uploaded;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public BomUploadStatus() {
    }

    public BomUploadStatus(String statusId, Boolean uploaded, int percentage) {
        this.statusId = statusId;
        this.uploaded = uploaded;
        this.percentage = percentage;
    }
}
