package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.Uploading.BomPart;
import com.spaceage.logistics.Model.Postgres.Uploading.BomTable;
import com.spaceage.logistics.Payload.enums.BomPartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BomPartRepository extends JpaRepository<BomPart, String> {
    List<BomPart> findByBomTable(BomTable bomTable);

    @Query("SELECT COUNT(b) FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId")
    long countByBomTableId(String bomTableId);

    @Query("SELECT b FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId AND b.status IN (:statuses)")
    List<BomPart> findByBomTableIdAndStatuses(@Param("bomTableId") String bomTableId , List<BomPartStatus> statuses);

    @Query("SELECT b.bomPartId FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId AND b.status = :status")
    List<String> findBomIdsByBomTableIdAndStatus(@Param("bomTableId") String bomTableId,
                                            @Param("status") BomPartStatus status);

    // Optional: If you prefer to use bomtable_id directly instead of the BomTable entity
    @Query("SELECT b FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId")
    List<BomPart> findByBomTableId(@Param("bomTableId") String bomTableId);

    @Query("SELECT b FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId AND b.status = :status")
    List<BomPart> findByBomTableIdAndStatus(@Param("bomTableId") String bomTableId,
                                           @Param("status") BomPartStatus status);

    @Query("SELECT b.bomPartId FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId")
    List<String> findBomIdsByBomTableId(@Param("bomTableId") String bomTableId);

    @Query("SELECT b FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId AND b.qualityCheck Is NULL AND b.status = :status")
    List<BomPart> findBomIdsByBomTableIdAndQualityCheckIsNullAndStatus(@Param("bomTableId") String bomTableId,@Param("status") BomPartStatus status);


    @Query("SELECT b FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId AND b.qualityCheck Is NULL")
    List<BomPart> findBomIdsByBomTableIdAndQualityCheckIsNull(@Param("bomTableId") String bomTableId);

    @Query("SELECT b FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId AND b.qualityCheck = true")
    List<BomPart> findBomIdsByBomTableIdAndQualityCheckIsTrue(@Param("bomTableId") String bomTableId);

    @Query("SELECT b FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId AND b.qualityCheck = false")
    List<BomPart> findBomIdsByBomTableIdAndQualityCheckIsFalse(@Param("bomTableId") String bomTableId);

    @Query("SELECT b FROM BomPart b WHERE b.bomTable.bomTableId = :bomTableId AND b.secondaryNo = :secondaryNo")
    List<BomPart> findByBomTableIdAndSecondaryNo(String bomTableId, String secondaryNo);

}