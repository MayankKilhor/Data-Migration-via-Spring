package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.Uploading.OriginCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginCustomerRepository extends JpaRepository<OriginCustomer, String> {
}
