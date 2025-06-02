package com.spaceage.logistics.Security;


import com.spaceage.logistics.Model.Postgres.Security.ApiAccessControl;
import com.spaceage.logistics.Model.Postgres.Security.Authority;
import com.spaceage.logistics.Repository.Postgres.ApiAccessControlRepository;
import com.spaceage.logistics.Security.Handler.AuthEntryPointJwt;
import com.spaceage.logistics.Security.Handler.CustomAccessDeniedHandler;
import com.spaceage.logistics.Security.JWT.JwtFilter;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private @Lazy UserDetailsService userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private CustomHeaderFilter customHeaderFilter;

    private final CorsFilter corsFilter;

    private final ApiAccessControlRepository apiAccessControlRepository;

    private static final String[] AUTH_WHITELIST = {
            "/api/contact/submit",
            "/api/auth/sendOtp",
            "/api/auth/verifyOtp",
            "/api/auth/signUp",
            "/api/auth/login",
            "/api/authorities/create-god-user",
            "/hello"
    };

    private static final String[] ROLE_WHITELIST = {
            "/api/authorities/createUserRole",
            "/api/authorities/createRole"
    };


    private static final String ADD_ROLE_AUTHORITY = "ADD_USER_ROLE";


    @Autowired
    public SecurityConfig(CorsFilter corsFilter, ApiAccessControlRepository apiAccessControlRepository) {
        this.corsFilter = corsFilter;
        this.apiAccessControlRepository = apiAccessControlRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        List<ApiAccessControl> apiAccessList = apiAccessControlRepository.findAll();
        Map<String, Set<String>> endpointAuthorityMap = new HashMap<>();
        List<String> publicEndpoints = new ArrayList<>();

        for (ApiAccessControl apiAccess : apiAccessList) {
            if (Boolean.TRUE.equals(apiAccess.getPublic())) {
                publicEndpoints.add(apiAccess.getEndpointPath());
            } else if (apiAccess.getAuthorities() != null && !apiAccess.getAuthorities().isEmpty()) {
                // Collecting authority names into a list or set
                Set<String> authorityNames = apiAccess.getAuthorities().stream()
                        .map(Authority::getName) // Extracting the authority name
                        .collect(Collectors.toSet());

                // Use the authority names as a whitelist or however you need to handle them
                endpointAuthorityMap.put(apiAccess.getEndpointPath(), authorityNames);
            }
        }

         http .cors(Customizer.withDefaults())
                .addFilterBefore(corsFilter, ChannelProcessingFilter.class)
                .csrf(csrf -> csrf.disable())
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(unauthorizedHandler)
                        .accessDeniedHandler(customAccessDeniedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .addFilterBefore(customHeaderFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> {

                            auth.requestMatchers(publicEndpoints.toArray(new String[0])).permitAll();


//                            // Dynamically add authority-based restrictions
//                            for (Map.Entry<String, String> entry : endpointAuthorityMap.entrySet()) {
//                                auth.requestMatchers(entry.getKey()).hasAuthority(entry.getValue());
//                            }

                    for (Map.Entry<String, Set<String>> entry : endpointAuthorityMap.entrySet()) {
                        String endpoint = entry.getKey();
                        Set<String> authorities = entry.getValue();

                        // Convert the Set of authorities into an array of strings for hasAnyAuthority
                        String[] authorityArray = authorities.toArray(new String[0]);

                        // Apply the restrictions: allow access if the user has any of the listed authorities
                        auth.requestMatchers(endpoint).hasAnyAuthority(authorityArray);
                    }

                        auth
                                .requestMatchers("/api/authorities/defaultConfiguration").permitAll()
                                .requestMatchers("/api/transfer/defaultConfiguration").permitAll()
                                .requestMatchers("/api/transfer/transferBOM").permitAll()
                                .requestMatchers("/api/bom/MIRN/LabelPDF").permitAll()
                                .requestMatchers(HttpMethod.PATCH, "/**").denyAll()
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                .requestMatchers(HttpMethod.TRACE, "/**").denyAll()
                                .requestMatchers(HttpMethod.HEAD, "/**").denyAll()
                                .requestMatchers(HttpMethod.PUT, "/**").denyAll()
                                .requestMatchers(HttpMethod.DELETE, "/**").denyAll()
                                .anyRequest().authenticated();
                            });
                http.authenticationProvider(authenticationProvider());
//                .httpBasic(Customizer.withDefaults())

                http.addFilterBefore((Filter) jwtFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();

    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }
}