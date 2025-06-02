package com.spaceage.logistics.Payload.Response;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    private boolean success;
    private String message;
    private String redirectUrl;
    private Map<String, Object> details = new HashMap<>();




    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(boolean success, String message, String redirectUrl, Map<String, Object> details) {
        this.success = success;
        this.message = message;
        this.redirectUrl = redirectUrl;
        this.details = details;
    }

    public ApiResponse(boolean success, String message, String redirectUrl) {
        this.success = success;
        this.message = message;
        this.redirectUrl = redirectUrl;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }


    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
    public void addDetail(String key, Object value) {
        details.put(key, value);
    }
}
