package com.logistics.migration.Payload.Response;

import java.util.HashMap;
import java.util.List;

public class ErrorResponse {
    private boolean success;
    private String message;
    private Object data;
    private HashMap<String,List<String>> details = new HashMap<>();

    public ErrorResponse(String message) {
        this.message = message;
    }
    public ErrorResponse(String message, HashMap<String,List<String>> error) {
        this.message = message;
        this.details= error;
    }
    public ErrorResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ErrorResponse(boolean success, String message, HashMap<String,List<String>> details) {
        this.success = success;
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<String, List<String>> getDetails() {
        return details;
    }

    public void setDetails(HashMap<String, List<String>> details) {
        this.details = details;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}