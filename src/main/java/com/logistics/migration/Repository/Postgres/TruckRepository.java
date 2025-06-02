package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.Shipping.ShippingTruck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<ShippingTruck, String> {

}
