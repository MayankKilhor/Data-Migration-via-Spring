package com.logistics.migration.Model.Postgres.Security;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "api_access_control")
public class ApiAccessControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "endpoint_path", nullable = false, unique = true)
    private String endpointPath;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "api_access_authority",  // Join table name
            joinColumns = @JoinColumn(name = "api_access_id"),  // Foreign key for ApiAccessControl
            inverseJoinColumns = @JoinColumn(name = "authority_id")  // Foreign key for Authority
    )
    private Set<Authority> authorities;

    @Column(name = "public")
    private Boolean isPublic  = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndpointPath() {
        return endpointPath;
    }

    public void setEndpointPath(String endpointPath) {
        this.endpointPath = endpointPath;
    }


    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }
}