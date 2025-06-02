package com.logistics.migration.Model.Postgres.Security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "authority_id")
    private String authorityId;

    @Column(name = "name", nullable = false, unique = true)
    private String name; // e.g., READ_PRIVILEGE, WRITE_PRIVILEGE

    @Column(name="description")
    private String description;


    @ManyToMany(mappedBy = "authorities")
    private Set<UserRole> userRoles;

    @ManyToMany(mappedBy = "authorities")
    private Set<ApiAccessControl> apiAccessControls;

    @ManyToOne(fetch = FetchType.EAGER) // Many UserRoles can be created by one User
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @JsonIgnoreProperties({"userId", "password_hash", "phoneNo", "created_at", "updated_at","verified"})
    private User createdBy;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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
}
