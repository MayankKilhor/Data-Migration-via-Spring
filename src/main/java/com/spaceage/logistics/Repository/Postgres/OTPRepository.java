package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.Security.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OTP, String> {
    Optional<OTP> findByEmail(String email);
}