package com.spaceage.logistics.Payload.Request.Truck;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddDriverRequest {


    @NotBlank(message = "name can't be empty!")
    private String name;

    @NotNull(message = "age can't be empty!")
    private Long age;

    @NotBlank(message = "phoneNo can't be empty!")
    private String phoneNo;

    @NotNull(message = "LinkToTruck can't be empty")
    private Boolean linkToTruck;

    private String truckId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Boolean getLinkToTruck() {
        return linkToTruck;
    }

    public void setLinkToTruck(Boolean linkToTruck) {
        this.linkToTruck = linkToTruck;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }
}
