package com.spaceage.logistics.Payload.Request.Role;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class AssignOrRemoveAuthorityRequest {

    @NotBlank(message = "roleId can't be empty!")
    private String roleId;


    private Set<String> authorityIds;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Set<String> getAuthorityIds() {
        return authorityIds;
    }

    public void setAuthorityIds(Set<String> authorityIds) {
        this.authorityIds = authorityIds;
    }
}
