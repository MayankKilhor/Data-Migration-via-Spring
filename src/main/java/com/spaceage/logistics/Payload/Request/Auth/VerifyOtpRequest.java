package com.spaceage.logistics.Payload.Request.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class VerifyOtpRequest {

    @NotBlank(message = "Email can't be empty!")
    @Email(message = "Email Address should be valid!")
    String email;

    @NotBlank(message = "OTP can't be empty!")
    String otp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
