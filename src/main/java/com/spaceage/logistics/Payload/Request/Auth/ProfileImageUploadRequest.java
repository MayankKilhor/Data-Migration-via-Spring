package com.spaceage.logistics.Payload.Request.Auth;

import org.springframework.web.multipart.MultipartFile;

public class ProfileImageUploadRequest {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
