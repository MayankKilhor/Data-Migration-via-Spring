package com.spaceage.logistics.Exceptions;

import java.util.Map;

public class MultiRowValidationException extends RuntimeException {
    private final Map<Integer, ErrorInfo> rowErrors;

    public MultiRowValidationException(String message, Map<Integer, ErrorInfo> rowErrors) {
        super(message);
        this.rowErrors = rowErrors;
    }

    public Map<Integer, ErrorInfo> getRowErrors() {
        return rowErrors;
    }

    public int getTotalErrorCount() {
        return rowErrors.values().stream()
                .mapToInt(ErrorInfo::getErrorCount)
                .sum();
    }
}
