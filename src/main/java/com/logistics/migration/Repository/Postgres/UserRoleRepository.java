package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.Security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    Optional<UserRole> findByName(String name);
}