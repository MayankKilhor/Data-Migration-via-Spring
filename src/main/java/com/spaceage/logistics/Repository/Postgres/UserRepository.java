package com.spaceage.logistics.Repository.Postgres;


import com.spaceage.logistics.Model.Postgres.Security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {


    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findOptionalUserByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}