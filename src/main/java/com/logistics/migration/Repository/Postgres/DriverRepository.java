package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.Shipping.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {

}
