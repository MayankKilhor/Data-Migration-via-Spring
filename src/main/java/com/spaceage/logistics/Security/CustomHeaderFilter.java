package com.spaceage.logistics.Security;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spaceage.logistics.Payload.Response.ApiResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;

@Component
@Order(1) // Set the order to control filter execution order
public class CustomHeaderFilter extends OncePerRequestFilter {
    private static final String MACHINE_ID_HEADER = "x-machineId";
    private static final String CUSTOM_MACHINE_ID = "123456"; // Set your custom machine ID here

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Set the custom x-machineId header with the desired value
        String requestURI = request.getRequestURI();
        if (requestURI != null && ((requestURI.equals("/hello")||(requestURI.equals("/"))))) {
            // If it is, skip the header check and continue the filter chain
            filterChain.doFilter(request, response);
            return;
        }
        String existingMachineId = request.getHeader(MACHINE_ID_HEADER);
        if (existingMachineId == null || !existingMachineId.equals(CUSTOM_MACHINE_ID)) {
            // Throw an error when the header is not present or its value does not match the desired value
            ApiResponse apiResponse = new ApiResponse(false, "Invalid x-machineId header value", "/api/auth/sendOtp");
            apiResponse.setDetails(new HashMap<>());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getWriter().write(convertObjectToJson(apiResponse));
            return;
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}

