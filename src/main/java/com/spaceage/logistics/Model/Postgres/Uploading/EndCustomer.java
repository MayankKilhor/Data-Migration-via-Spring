package com.spaceage.logistics.Model.Postgres.Uploading;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.spaceage.logistics.Model.Postgres.Security.User;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "end_customer")
public class EndCustomer {

    @Id
    @Column(name = "end_customer_id", nullable = false)
    private String endCustomerId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "website", length = 1000)
    private String website;


    @Column(name= "country",nullable = false)
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;


    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_designation")
    private String contactDesignation;

    @Column(name = "contact_phone_no")
    private String contactPhoneNo;


    @OneToMany(mappedBy = "endCustomer",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BomTable> bomTables;

    @ManyToOne(fetch = FetchType.EAGER) // Many UserRoles can be created by one User
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @JsonBackReference
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER) // Many UserRoles can be created by one User
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id")
    @JsonBackReference
    private User updatedBy;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at",nullable = false)
    private Date updatedAt;

    public String getEndCustomerId() {
        return endCustomerId;
    }

    public void setEndCustomerId(String endCustomerId) {
        this.endCustomerId = endCustomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactDesignation() {
        return contactDesignation;
    }

    public void setContactDesignation(String contactDesignation) {
        this.contactDesignation = contactDesignation;
    }

    public String getContactPhoneNo() {
        return contactPhoneNo;
    }

    public void setContactPhoneNo(String contactPhoneNo) {
        this.contactPhoneNo = contactPhoneNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<BomTable> getBomTables() {
        return bomTables;
    }

    public void setBomTables(List<BomTable> bomTables) {
        this.bomTables = bomTables;
    }
}
