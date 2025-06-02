package com.spaceage.logistics.Repository.Postgres;


import com.spaceage.logistics.Model.Postgres.Shipping.ShippingTruck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<ShippingTruck, String> {

}
