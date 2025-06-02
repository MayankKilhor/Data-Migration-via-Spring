package com.spaceage.logistics.Repository.Postgres;


import com.spaceage.logistics.Model.Postgres.Shipping.ReceipentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceipentInfoRepository extends JpaRepository<ReceipentInfo, String> {

}
