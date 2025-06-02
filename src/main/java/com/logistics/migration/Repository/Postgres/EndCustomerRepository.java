package com.logistics.migration.Repository.Postgres;

import com.logistics.migration.Model.Postgres.Uploading.EndCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EndCustomerRepository extends JpaRepository<EndCustomer, String> {

    @Query("SELECT e FROM EndCustomer e WHERE e.endCustomerId LIKE :pattern")
    Optional<EndCustomer> findByEndCustomerIdPattern(@Param("pattern") String pattern);
}
