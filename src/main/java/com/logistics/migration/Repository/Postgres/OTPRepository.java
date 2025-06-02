package com.logistics.migration.Repository.Postgres;

import com.logistics.migration.Model.Postgres.Security.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OTP, String> {
    Optional<OTP> findByEmail(String email);
}