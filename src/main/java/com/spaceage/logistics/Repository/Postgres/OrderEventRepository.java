package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEventRepository extends JpaRepository<OrderEvent, Long> {
}