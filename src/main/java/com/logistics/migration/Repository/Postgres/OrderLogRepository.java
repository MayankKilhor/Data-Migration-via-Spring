package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.OrderLog;
import com.logistics.migration.Model.Postgres.PackagingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderLogRepository extends JpaRepository<OrderLog, Long> {

    Optional<OrderLog> findByPackagingOrder(PackagingOrder packagingOrder);
}