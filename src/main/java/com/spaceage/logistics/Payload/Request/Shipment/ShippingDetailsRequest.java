package com.spaceage.logistics.Payload.Request.Shipment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ShippingDetailsRequest {

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    @NotBlank(message = "palledId can't be empty!")
    private String palletId;

    @NotBlank(message = "name can't be empty!")
    private String name;

    @NotBlank(message = "phone number can't be empty!")
    private String phoneNo;

    @NotBlank(message = "address can't be empty!")
    private String address;

    @NotBlank(message = "city can't be empty!")
    private String city;

    @NotBlank(message = "state can't be empty!")
    private String state;

    @NotBlank(message = "country can't be empty!")
    private String country;

    @NotBlank(message = "zipCode can't be empty!")
    private String zipCode;

    @NotBlank(message = "driverId can't be empty!")
    private String driverId;

    @NotBlank(message = "truckId can't be empty!")
    private String truckId;

    @NotNull(message = "Truck dryWeight can't be empty!")
    private Double dryWeight;

    @NotNull(message = "Truck wetWeight can't be empty!")
    private Double wetWeight;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public Double getDryWeight() {
        return dryWeight;
    }

    public void setDryWeight(Double dryWeight) {
        this.dryWeight = dryWeight;
    }

    public Double getWetWeight() {
        return wetWeight;
    }

    public void setWetWeight(Double wetWeight) {
        this.wetWeight = wetWeight;
    }

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public String getPalletId() {
        return palletId;
    }

    public void setPalletId(String palletId) {
        this.palletId = palletId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
