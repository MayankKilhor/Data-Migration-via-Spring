package com.spaceage.logistics.Payload.Request.Role;

import jakarta.validation.constraints.NotBlank;

public class CreateAuthorityRequest {

    @NotBlank(message = "roleId can't be empty!")
    private String authorityId;

    @NotBlank(message = "name can't be empty!")
    private String name;

    @NotBlank(message = "description can't be empty!")
    private String description;

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
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
}
