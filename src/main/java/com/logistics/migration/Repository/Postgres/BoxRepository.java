package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box, String> {


}