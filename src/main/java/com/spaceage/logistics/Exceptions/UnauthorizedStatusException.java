package com.spaceage.logistics.Exceptions;

public class UnauthorizedStatusException extends RuntimeException {

    String status;
    public UnauthorizedStatusException(String message) {
        super(message);
    }
    public UnauthorizedStatusException(String message, String status) {
        super(message);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}