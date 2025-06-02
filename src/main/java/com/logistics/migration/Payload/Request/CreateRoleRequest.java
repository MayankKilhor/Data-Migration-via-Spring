package com.logistics.migration.Payload.Request;

import jakarta.validation.constraints.NotBlank;

public class CreateRoleRequest {

    @NotBlank(message = "roleId can't be empty!")
    private String roleId;

    @NotBlank(message = "name can't be empty!")
    private String name;

    @NotBlank(message = "description can't be empty!")
    private String description;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
