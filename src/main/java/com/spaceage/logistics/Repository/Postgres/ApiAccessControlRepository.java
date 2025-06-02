package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.Security.ApiAccessControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ApiAccessControlRepository extends JpaRepository<ApiAccessControl, Long> {
//    @Cacheable("apiAccessControlCache") // The cache name "apiAccessControlCache"
//    List<ApiAccessControl> findAll();

    Optional<ApiAccessControl> findByEndpointPath(String endpointPath);
}
