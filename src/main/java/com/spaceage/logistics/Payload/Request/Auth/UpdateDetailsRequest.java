package com.spaceage.logistics.Payload.Request.Auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateDetailsRequest {


    @NotBlank(message = "Name can't be empty!")
    @Size(max = 25, message = "Name must be at most 25 characters!")
    private String name;


    @Size(max = 25, message = "Designation must be at most 25 characters!")
    private String designation;


    @Size(max = 25, message = "Location must be at most 25 characters!")
    private String location;

    @NotBlank(message = "Phone Number can't be empty!")
    @Size(max = 15, message = "Phone Number must be at most 15 characters!")
    @Pattern(
            regexp = "^\\+\\d{1,3}-\\d{7,12}$",
            message = "Phone Number must be in the format +<1-3 digits>-<7-12 digits> (e.g., +91-9876543210)"
    )
    private String phoneNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
