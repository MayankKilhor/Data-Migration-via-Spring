package com.spaceage.logistics.Payload.Request.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SignUpRequest {

    @NotBlank(message = "Name can't be empty!")
    @Size(max = 100, message = "Name must be at most 100 characters!")
    private String name;

    @NotBlank(message = "Phone No. can't be empty!")
    @Size(max = 15, message = "Phone Number must be at most 15 characters!")
    @Pattern(
            regexp = "^\\+\\d{1,3}-\\d{7,12}$",
            message = "Phone Number must be in the format +<1-3 digits>-<7-12 digits> (e.g., +91-9876543210)"
    )
    private String phoneNo;

    private String countryCode;

    @NotBlank(message = "Email can't be empty!")
    @Email(message = "Email address should be valid!")
    @Size(max = 100, message = "Email must be at most 100 characters!")
    private String email;

    @NotBlank(message = "Password can't be empty!")
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters!")
    private String password;

    @NotBlank(message = "Confirm Password can't be empty!")
    @Size(min = 6, max = 50, message = "Confirm Password must be between 6 and 50 characters!")
    private String confirm_password;

    private String selectedPermission;

    public SignUpRequest() {
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getSelectedPermission() {
        return selectedPermission;
    }

    public void setSelectedPermission(String selectedPermission) {
        this.selectedPermission = selectedPermission;
    }
}
