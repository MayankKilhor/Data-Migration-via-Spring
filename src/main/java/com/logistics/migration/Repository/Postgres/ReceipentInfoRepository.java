package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.Shipping.ReceipentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceipentInfoRepository extends JpaRepository<ReceipentInfo, String> {

}
