package com.spaceage.logistics.Model.MySQL;

import jakarta.persistence.*;

@Entity
@Table(name = "packaging_type")
public class PackagingType {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "type", length = 255)
    private String type;

    @Column(name = "description", length = 100)
    private String description;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
