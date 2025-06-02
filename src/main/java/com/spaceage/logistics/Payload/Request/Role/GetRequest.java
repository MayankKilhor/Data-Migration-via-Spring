package com.spaceage.logistics.Payload.Request.Role;

import jakarta.validation.constraints.NotBlank;

public class GetRequest {
    @NotBlank(message = "username  can't be empty!")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
