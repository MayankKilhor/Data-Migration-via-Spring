package com.spaceage.logistics.Payload.Request.BOM;

import com.spaceage.logistics.Payload.enums.FileUploadBOM;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadRequest {

    private FileUploadBOM type;

    @NotBlank(message = "bomTableId can't be empty!")
    private String  bomTableId;

    private MultipartFile file;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public FileUploadBOM getType()
    {
        return type;
    }

    public void setType(FileUploadBOM type) {
        this.type = type;
    }

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }
}
