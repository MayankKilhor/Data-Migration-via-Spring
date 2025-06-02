package com.logistics.migration.Repository.Postgres;



import com.logistics.migration.Model.Postgres.PackagingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PackagingOrderRepository extends JpaRepository<PackagingOrder, String> {


}
