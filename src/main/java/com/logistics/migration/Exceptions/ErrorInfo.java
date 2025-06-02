package com.logistics.migration.Exceptions;

import java.util.List;

public class ErrorInfo {
    private List<String> errorMessages;

    private Long errorCount;

    public ErrorInfo(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public int getErrorCount() {
        return errorMessages.size();
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void setErrorCount(Long errorCount) {
        this.errorCount = errorCount;
    }

    public ErrorInfo(List<String> errorMessages, Long errorCount) {
        this.errorMessages = errorMessages;
        this.errorCount = errorCount;
    }
}
