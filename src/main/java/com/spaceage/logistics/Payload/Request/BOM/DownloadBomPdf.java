package com.spaceage.logistics.Payload.Request.BOM;

import com.spaceage.logistics.Payload.enums.FileUploadBOM;
import jakarta.validation.constraints.NotBlank;

public class DownloadBomPdf {

    @NotBlank(message = "bomTableId can't be empty!")
    private String bomTableId;

    private FileUploadBOM type;

    public @NotBlank(message = "bomTableId can't be empty!") String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(@NotBlank(message = "bomTableId can't be empty!") String bomTableId) {
        this.bomTableId = bomTableId;
    }

    public FileUploadBOM getType() {
        return type;
    }

    public void setType(FileUploadBOM type) {
        this.type = type;
    }
}
