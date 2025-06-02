package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, String> {

    @Query("SELECT b FROM Part b WHERE b.bomPartId = :bomPartId")
    List<Part> findByBomPartId(@Param("bomPartId") String bomPartId);



}