package com.spaceage.logistics.Payload.Request.Auth;

import jakarta.validation.constraints.NotBlank;

public class ChangePasswordRequest {



    @NotBlank(message = "Old Password can't be empty!")
    private String old_password;

    @NotBlank(message = "New Password can't be empty!")
    private String new_password;

    @NotBlank(message = "Confirm Password can't be empty!")
    private String confirm_password;


    public ChangePasswordRequest() {
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}
