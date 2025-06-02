package com.logistics.migration.Exceptions.Handler;



import com.logistics.migration.Exceptions.*;
import com.logistics.migration.Payload.Response.ApiErrorResponse;
import com.logistics.migration.Payload.Response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequestException(BadRequestException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(false, e.getMessage(), new HashMap<>());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ApiErrorResponse> handleInternalServerErrorException(InternalServerErrorException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiErrorResponse(false, e.getMessage(), new HashMap<>()));
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ApiErrorResponse> handleInternalServerErrorException(DatabaseException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiErrorResponse(false, e.getMessage(), new HashMap<>()));
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiErrorResponse(false, ex.getMessage(), new HashMap<>()));
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<?> missingRequestHeaderException(MissingRequestHeaderException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiErrorResponse(false, ex.getMessage(), new HashMap<>()));
    }



    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error = "Invalid request. Please provide a valid JSON payload.";
        ApiErrorResponse errorDetails = new ApiErrorResponse(false, error, new HashMap<>());

        return ResponseEntity.status(status).body(errorDetails);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleAllUncaughtException(Exception e, WebRequest request) {
        logger.error("Unexpected error:"+ e.getMessage());
        ApiErrorResponse errorResponse = new ApiErrorResponse(false, "An unexpected error occurred", new HashMap<>());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        HashMap<String, List<String>> details = new HashMap<>();
        details.put("errors", errorList);
        ErrorResponse errorDetails = new ErrorResponse(false, "Request validation failed", details);
        return handleExceptionInternal(ex, errorDetails, headers, status, request);
    }



}
