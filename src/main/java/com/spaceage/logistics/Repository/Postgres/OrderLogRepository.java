package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.OrderLog;
import com.spaceage.logistics.Model.Postgres.PackagingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderLogRepository extends JpaRepository<OrderLog, Long> {

    Optional<OrderLog> findByPackagingOrder(PackagingOrder packagingOrder);
}