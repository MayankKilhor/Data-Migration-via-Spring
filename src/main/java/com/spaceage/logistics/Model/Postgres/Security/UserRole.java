package com.spaceage.logistics.Model.Postgres.Security;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "role_id", nullable = false)
    private String roleId;

    @Column(name = "name", unique = true,nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;

    @ManyToOne(fetch = FetchType.EAGER) // Many UserRoles can be created by one User
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @JsonBackReference
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER) // Many UserRoles can be created by one User
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id")
    @JsonBackReference
    private User updatedBy;


    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at",nullable = false)
    private Date updated_at;

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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }
}
