package com.logistics.migration.Repository.Postgres;

import com.logistics.migration.Model.Postgres.Uploading.OriginCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginCustomerRepository extends JpaRepository<OriginCustomer, String> {
}
