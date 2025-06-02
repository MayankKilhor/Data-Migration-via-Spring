package com.spaceage.logistics.Repository.Postgres;


import com.spaceage.logistics.Model.Postgres.Shipping.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {

}
