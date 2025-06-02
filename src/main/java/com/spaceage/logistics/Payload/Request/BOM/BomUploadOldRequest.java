package com.spaceage.logistics.Payload.Request.BOM;

import org.springframework.web.multipart.MultipartFile;

public class BomUploadOldRequest {

//    @NotBlank(message = "shipmentId can't be empty!")
//    private String shipmentId;


    private MultipartFile file;

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
