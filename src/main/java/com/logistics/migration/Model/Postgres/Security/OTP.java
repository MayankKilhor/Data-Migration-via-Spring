package com.logistics.migration.Model.Postgres.Security;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "otp")
public class OTP {


    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "otp", nullable = false)
    private String otp;

    @Column(name="verified")
    private Boolean verified;

    @Column(name = "expiry_time", nullable = false)
    private LocalDateTime expiryTime;


    public OTP() {
        this.verified=false;
    }

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

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}