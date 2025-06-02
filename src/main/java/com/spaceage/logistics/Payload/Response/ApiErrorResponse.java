package com.spaceage.logistics.Payload.Response;

import java.util.HashMap;
import java.util.Map;

public class ApiErrorResponse {
    private boolean success;
    private String message;
    private Map<String, Object> details = new HashMap<>();

    public ApiErrorResponse(String message) {
        this.message = message;
    }

    public ApiErrorResponse(boolean success, String message, Map<String,Object> data) {
        this.success = success;
        this.message = message;
        this.details = data;
    }

    public ApiErrorResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public void addDetail(String key, Object value) {
        details.put(key, value);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}