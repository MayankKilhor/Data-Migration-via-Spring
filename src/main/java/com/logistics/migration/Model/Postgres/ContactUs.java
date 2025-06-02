package com.logistics.migration.Model.Postgres;


import com.logistics.migration.Payload.enums.BusinessInterest;
import com.logistics.migration.Payload.enums.StatusType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contact_us")
public class ContactUs {
    @Id
    @Column(name = "query_id", nullable = false)
    private String query_id;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNo;

    @Column(name = "website")
    private String website;

    @Column(name = "company")
    private String company;

    @Column(name = "country",nullable = false)
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(name = "business_interest", nullable = false)
    private BusinessInterest businessInterest;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusType status;

    @Column(name = "message",nullable = false)
    private String message;

    @Column(name = "created_at",nullable = false)
    private Date createdAt;

    public String getQuery_id() {
        return query_id;
    }

    public void setQuery_id(String query_id) {
        this.query_id = query_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BusinessInterest getBusinessInterest() {
        return businessInterest;
    }

    public void setBusinessInterest(BusinessInterest businessInterest) {
        this.businessInterest = businessInterest;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ContactUs(String name, String email, String phoneNo, String website, String company, String country, BusinessInterest businessInterest, String message) {
        this.Name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.website = website;
        this.company = company;
        this.country = country;
        this.businessInterest = businessInterest;
        this.message = message;
    }

    public ContactUs() {
    }
}
