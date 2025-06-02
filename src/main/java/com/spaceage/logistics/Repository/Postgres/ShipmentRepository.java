package com.spaceage.logistics.Repository.Postgres;


import com.spaceage.logistics.Model.Postgres.Shipping.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
    @Query("SELECT s FROM Shipment s WHERE s.shipment_id = :shipmentId")
    Optional<Shipment> findByShipmentId(@Param("shipmentId") String shipmentId);
}
