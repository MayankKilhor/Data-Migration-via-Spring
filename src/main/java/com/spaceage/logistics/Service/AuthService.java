package com.spaceage.logistics.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.spaceage.logistics.Exceptions.BadRequestException;


import com.spaceage.logistics.Model.Postgres.Security.User;
import com.spaceage.logistics.Repository.Postgres.UserRepository;
import com.spaceage.logistics.Security.JWT.JwtUtil;
import com.spaceage.logistics.Security.UserPrincipal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;



    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            System.out.println("User not found: " + username);
            // You can throw a custom exception or add more details here
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
        return new UserPrincipal(user);
    }

}
