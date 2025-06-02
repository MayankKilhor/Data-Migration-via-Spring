package com.logistics.migration.Model.MySQL;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orgin")
public class Orgin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cust_id")
    private Integer custId;

    @Column(name = "unit_id")
    private Integer unitId;

    @Column(name = "shipment_no", unique = true)
    private String shipmentNo;

    @Column(name = "shipment_route_from")
    private String shipmentRouteFrom;

    @Column(name = "shipment_route_to")
    private String shipmentRouteTo;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "vehicle_no")
    private String vehicleNo;

    @Column(name = "lr_no")
    private String lrNo;

    @Column(name = "lr_date")
    private String lrDate;

    @Column(name = "transporter_name")
    private String transporterName;

    @Column(name = "transit_days")
    private String transitDays;

    @Column(name = "fast_mode")
    private String fastMode;

    @Column(name = "isfastFlag")
    private Integer isfastFlag;

    @Column(name = "status")
    private String status;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    private LocalDateTime updatedDate;

    @Column(name = "delay_applicable_or_not")
    private String delayApplicableOrNot;

    @Column(name = "fast_mode_applicable_or_not")
    private String fastModeApplicableOrNot;

    @Column(name = "odc")
    private String odc;

    @Column(name = "vehicle_reported_on")
    private LocalDateTime vehicleReportedOn;

    @Column(name = "org_status")
    private String orgStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getShipmentNo() {
        return shipmentNo;
    }

    public void setShipmentNo(String shipmentNo) {
        this.shipmentNo = shipmentNo;
    }

    public String getShipmentRouteFrom() {
        return shipmentRouteFrom;
    }

    public void setShipmentRouteFrom(String shipmentRouteFrom) {
        this.shipmentRouteFrom = shipmentRouteFrom;
    }

    public String getShipmentRouteTo() {
        return shipmentRouteTo;
    }

    public void setShipmentRouteTo(String shipmentRouteTo) {
        this.shipmentRouteTo = shipmentRouteTo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getLrNo() {
        return lrNo;
    }

    public void setLrNo(String lrNo) {
        this.lrNo = lrNo;
    }

    public String getLrDate() {
        return lrDate;
    }

    public void setLrDate(String lrDate) {
        this.lrDate = lrDate;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public String getTransitDays() {
        return transitDays;
    }

    public void setTransitDays(String transitDays) {
        this.transitDays = transitDays;
    }

    public String getFastMode() {
        return fastMode;
    }

    public void setFastMode(String fastMode) {
        this.fastMode = fastMode;
    }

    public Integer getIsfastFlag() {
        return isfastFlag;
    }

    public void setIsfastFlag(Integer isfastFlag) {
        this.isfastFlag = isfastFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getDelayApplicableOrNot() {
        return delayApplicableOrNot;
    }

    public void setDelayApplicableOrNot(String delayApplicableOrNot) {
        this.delayApplicableOrNot = delayApplicableOrNot;
    }

    public String getFastModeApplicableOrNot() {
        return fastModeApplicableOrNot;
    }

    public void setFastModeApplicableOrNot(String fastModeApplicableOrNot) {
        this.fastModeApplicableOrNot = fastModeApplicableOrNot;
    }

    public String getOdc() {
        return odc;
    }

    public void setOdc(String odc) {
        this.odc = odc;
    }

    public LocalDateTime getVehicleReportedOn() {
        return vehicleReportedOn;
    }

    public void setVehicleReportedOn(LocalDateTime vehicleReportedOn) {
        this.vehicleReportedOn = vehicleReportedOn;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }
}
