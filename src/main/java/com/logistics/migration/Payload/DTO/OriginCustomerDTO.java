package com.logistics.migration.Payload.DTO;

import java.util.Date;

public class OriginCustomerDTO {
    private String originCustomerId;
    private String name;
    private String description;
    private String country;
    private String state;
    private String city;
    private String address;
    private String postalCode;
    private String contactName;
    private String contactDesignation;
    private String contactPhoneNo;
    private String website;
    private String createdBy;  // User ID of the creator
    private String updatedBy;  // User ID of the updater
    private Date createdAt;
    private Date updatedAt;

    public OriginCustomerDTO(String originCustomerId, String name, String description, String country, String state,
                             String city, String address, String postalCode, String contactName,
                             String contactDesignation, String contactPhoneNo, String website,
                             String createdBy, String updatedBy, Date createdAt, Date updatedAt) {
        this.originCustomerId = originCustomerId;
        this.name = name;
        this.description = description;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.contactName = contactName;
        this.contactDesignation = contactDesignation;
        this.contactPhoneNo = contactPhoneNo;
        this.website = website;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public String getOriginCustomerId() { return originCustomerId; }
    public void setOriginCustomerId(String originCustomerId) { this.originCustomerId = originCustomerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }

    public String getContactDesignation() { return contactDesignation; }
    public void setContactDesignation(String contactDesignation) { this.contactDesignation = contactDesignation; }

    public String getContactPhoneNo() { return contactPhoneNo; }
    public void setContactPhoneNo(String contactPhoneNo) { this.contactPhoneNo = contactPhoneNo; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

}
