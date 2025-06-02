package com.spaceage.logistics.Payload.Request.BOM;

import com.spaceage.logistics.Payload.enums.ShippingLoc;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.multipart.MultipartFile;

public class BomUploadRequest {


    @NotBlank(message = "modelId can't be empty")
    private String modelId;

    @NotBlank(message = "projectId can't be empty")
    private String projectId;

    @NotBlank(message= "originCustomerId can't be empty")
    private String originCustomerId;

    @NotBlank(message= "endCustomerId can't be empty")
    private String endCustomerId;

    @NotBlank(message = "lotRefNo can't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,15}$", message = "lotRefNo must be alphanumeric and up to 15 characters")
    private String lotRefNo;


    @NotNull(message= "lotSize can't be null")
    private Long lotSize;

    private Long containerCount;

    private ShippingLoc shippingLoc;

    private MultipartFile file;

    public String getModelId(){
        return modelId;
    }

    public void setModelId(String modelId){
        this.modelId = modelId;
    }

    public String getProjectId(){
        return projectId;
    }

    public void setProjectId(String projectId){
        this.projectId = projectId;
    }

    public String getOriginCustomerId(){
        return originCustomerId;
    }

    public void setOriginCustomerId(String originCustomerId){
        this.originCustomerId = originCustomerId;
    }

    public String getEndCustomerId(){
        return endCustomerId;
    }

    public void setEndCustomerId(String endCustomerId){
        this.endCustomerId = endCustomerId;
    }

    public String getLotRefNo(){
        return lotRefNo;
    }

    public void setLotRefNo(String lotRefNo){
        this.lotRefNo = lotRefNo;
    }

    public ShippingLoc getShippingLoc() {
        return shippingLoc;
    }

    public void setShippingLoc(ShippingLoc shippingLoc) {
        this.shippingLoc = shippingLoc;
    }

    public Long getLotSize(){
        return lotSize;
    }

    public void setLotSize(Long lotSize){
        this.lotSize = lotSize;
    }

    public Long getContainerCount(){
        return containerCount;
    }

    public void setContainerCount(Long containerCount){
        this.containerCount = containerCount;
    }

//    public String getShipmentId() {
//        return shipmentId;
//    }
//
//    public void setShipmentId(String shipmentId) {
//        this.shipmentId = shipmentId;
//    }


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
