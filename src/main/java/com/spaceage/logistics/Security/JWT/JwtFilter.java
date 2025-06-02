package com.spaceage.logistics.Security.JWT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spaceage.logistics.Payload.Response.ApiErrorResponse;
import com.spaceage.logistics.Security.UserPrincipal;
import com.spaceage.logistics.Service.AuthService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private AuthService authService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;
		try{
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.extractUsername(jwtToken);
			} catch (IllegalArgumentException e) {
				logger.error("Unable to get JWT Token", e);
				sendErrorResponse(response, "Unable to get JWT Token", HttpServletResponse.SC_BAD_REQUEST);
				return;
			} catch (ExpiredJwtException e) {
				logger.error("JWT Token has expired", e);
				sendErrorResponse(response, "JWT Token has expired", HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}catch (JwtException e) {
				// Handle wrong or malformed JWT token
				logger.error("Invalid JWT Token", e);
				sendErrorResponse(response, "Invalid JWT Token", HttpServletResponse.SC_UNAUTHORIZED);
				return; // Stop filter chain
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");

		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserPrincipal userDetails = this.authService.loadUserByUsername(username);

			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				// Token is not valid, send a custom response
				logger.warn("JWT Token is not valid");
				sendErrorResponse(response, "JWT Token is not valid", HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
		}
		chain.doFilter(request, response);
		} catch (UsernameNotFoundException ex) {
			// Handle case where user is not found
			logger.error("User not found: " + ex.getMessage());
			sendErrorResponse(response, "User not found, Error= "+ex.getMessage(), HttpServletResponse.SC_NOT_FOUND);
		} catch (IllegalArgumentException e) {
			logger.error("Unable to get JWT Token", e);
			sendErrorResponse(response, "Unable to get JWT Token", HttpServletResponse.SC_BAD_REQUEST);
		} catch (ExpiredJwtException e) {
			logger.error("JWT Token has expired", e);
			sendErrorResponse(response, "JWT Token has expired", HttpServletResponse.SC_UNAUTHORIZED);
		} catch (JwtException e) {
			// Handle wrong or malformed JWT token
			logger.error("Invalid JWT Token", e);
			sendErrorResponse(response, "Invalid JWT Token", HttpServletResponse.SC_UNAUTHORIZED);
		} catch (Exception e) {
			// Catch general exceptions and return 500 Internal Server Error
			logger.error("An unexpected error occurred", e);
			sendErrorResponse(response, "An internal server error occurred, Error= "+e.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	private void sendErrorResponse(HttpServletResponse response, String message, int statusCode) throws IOException {
		response.setStatus(statusCode); // Set HTTP status code
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// Build custom JSON response
		ApiErrorResponse errorResponse = new ApiErrorResponse(false,"An error occured!");
		errorResponse.addDetail("error",message);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = objectMapper.writeValueAsString(errorResponse); // Serialize to JSON

		// Write JSON response to the output stream
		response.getWriter().write(jsonResponse);
	}

}