package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEventRepository extends JpaRepository<OrderEvent, Long> {
}