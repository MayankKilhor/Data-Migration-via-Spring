package com.spaceage.logistics.Payload.Request;

import com.spaceage.logistics.Payload.enums.BusinessInterest;
import jakarta.validation.constraints.NotBlank;



public class ContactUsRequest {



    @NotBlank(message = "Name can not be blank")
    private String Name;

    private String email;

    private String phoneNo;

    private String website;

    private String company;

    private String country;

    private BusinessInterest businessInterest;

    private String message;


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



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
