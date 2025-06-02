package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.Uploading.BomTable;
import com.logistics.migration.Payload.DTO.BomTableDTO;
import com.logistics.migration.Payload.enums.BomTableStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BomTableRepository extends JpaRepository<BomTable, String> {

//    @Query("SELECT b FROM BomTable b WHERE b.createdBy.userId = :customerId")
//    List<BomTable> findByCustomerId(@Param("customerId") String customerId);

    @Query("SELECT b FROM BomTable b WHERE b.status = :status")
    List<BomTable> findByStatus(@Param("status") BomTableStatus status);

    @Query("SELECT b FROM BomTable b WHERE b.status IN (:statuses)")
    List<BomTable> findByStatuses(List<BomTableStatus> statuses);

//    @Query("SELECT b FROM BomTable b WHERE b.status = :status AND b.packagingOrder IS NULL")
//    List<BomTable> findByStatusAndPackagingOrderIsNull(@Param("status") BomTableStatus status);

    @Query("SELECT b FROM BomTable b WHERE b.status = :status AND b.createdBy.id = :userId")
    List<BomTable> findByStatusAndUserId(@Param("status") BomTableStatus status, @Param("userId") String userId);

    @Query("SELECT b FROM BomTable b WHERE b.status IN (:statuses) AND b.createdBy.id = :userId")
    List<BomTable> findByStatusesAndUserId(@Param("statuses") List<BomTableStatus> statuses, @Param("userId") String userId);

    Optional<BomTable> findByLotRefNo(String lotRefNo);


    @Query("SELECT b FROM BomTable b WHERE b.bomTableId = :bomTableId")
    Optional<BomTable> findByBomTableId(@Param("bomTableId") String bomTableId);

    @Query("SELECT new com.spaceage.logistics.Payload.DTO.BomTableDTO(" +
            "b.bomTableId, b.lotRefNo, b.partCount, b.mirnPartCount, b.pendingForPickupPartCount, " +
            "b.acknowledgedPartCount, b.qcFailedPartCount, b.partlabelPartCount, b.bomcompletePartCount, " +
            "b.errorPartCount, b.s3Location, b.s3Key, b.status, b.acknowledgementStatus, b.qualityCheckStatus, " +
            "b.partLabelStatus, b.MIRN_Url, b.qualityCheckUrl, b.partLabelUrl, b.lotSize, b.containerCount, " +
            "b.shippingLoc, b.createdAt, b.updatedAt, " +
            "b.model.modelId, b.project.projectId, b.endCustomer.endCustomerId, " +
            "b.originCustomer.originCustomerId, b.createdBy.userId, b.updatedBy.userId) " +
            "FROM BomTable b WHERE b.createdBy.userId = :customerId")
    List<BomTableDTO> findByCustomerId(@Param("customerId") String customerId);

    @Query("SELECT new com.spaceage.logistics.Payload.DTO.BomTableDTO(" +
            "b.bomTableId, b.lotRefNo, b.partCount, b.mirnPartCount, b.pendingForPickupPartCount, " +
            "b.acknowledgedPartCount, b.qcFailedPartCount, b.partlabelPartCount, b.bomcompletePartCount, " +
            "b.errorPartCount, b.s3Location, b.s3Key, b.status, b.acknowledgementStatus, b.qualityCheckStatus, " +
            "b.partLabelStatus, b.MIRN_Url, b.qualityCheckUrl, b.partLabelUrl, b.lotSize, b.containerCount, " +
            "b.shippingLoc, b.createdAt, b.updatedAt, " +
            "b.model.modelId, b.project.projectId, b.endCustomer.endCustomerId, " +
            "b.originCustomer.originCustomerId, b.createdBy.userId, b.updatedBy.userId) " +
            "FROM BomTable b WHERE b.status = :status")
    List<BomTableDTO> DTOfindByStatus(@Param("status") BomTableStatus status);

    @Query("SELECT new com.spaceage.logistics.Payload.DTO.BomTableDTO(" +
            "b.bomTableId, b.lotRefNo, b.partCount, b.mirnPartCount, b.pendingForPickupPartCount, " +
            "b.acknowledgedPartCount, b.qcFailedPartCount, b.partlabelPartCount, b.bomcompletePartCount, " +
            "b.errorPartCount, b.s3Location, b.s3Key, b.status, b.acknowledgementStatus, b.qualityCheckStatus, " +
            "b.partLabelStatus, b.MIRN_Url, b.qualityCheckUrl, b.partLabelUrl, b.lotSize, b.containerCount, " +
            "b.shippingLoc, b.createdAt, b.updatedAt, " +
            "b.model.modelId, b.project.projectId, b.endCustomer.endCustomerId, " +
            "b.originCustomer.originCustomerId, b.createdBy.userId, b.updatedBy.userId) " +
            "FROM BomTable b WHERE b.status IN (:statuses)")
    List<BomTableDTO> DTOfindByStatuses(@Param("statuses") List<BomTableStatus> statuses);

    @Query("SELECT new com.spaceage.logistics.Payload.DTO.BomTableDTO(" +
            "b.bomTableId, b.lotRefNo, b.partCount, b.mirnPartCount, b.pendingForPickupPartCount, " +
            "b.acknowledgedPartCount, b.qcFailedPartCount, b.partlabelPartCount, b.bomcompletePartCount, " +
            "b.errorPartCount, b.s3Location, b.s3Key, b.status, b.acknowledgementStatus, b.qualityCheckStatus, " +
            "b.partLabelStatus, b.MIRN_Url, b.qualityCheckUrl, b.partLabelUrl, b.lotSize, b.containerCount, " +
            "b.shippingLoc, b.createdAt, b.updatedAt, " +
            "b.model.modelId, b.project.projectId, b.endCustomer.endCustomerId, " +
            "b.originCustomer.originCustomerId, b.createdBy.userId, b.updatedBy.userId) " +
            "FROM BomTable b WHERE b.status = :status AND b.packagingOrder IS NULL")
    List<BomTableDTO> findByStatusAndPackagingOrderIsNull(@Param("status") BomTableStatus status);

    @Query("SELECT new com.spaceage.logistics.Payload.DTO.BomTableDTO(" +
            "b.bomTableId, b.lotRefNo, b.partCount, b.mirnPartCount, b.pendingForPickupPartCount, " +
            "b.acknowledgedPartCount, b.qcFailedPartCount, b.partlabelPartCount, b.bomcompletePartCount, " +
            "b.errorPartCount, b.s3Location, b.s3Key, b.status, b.acknowledgementStatus, b.qualityCheckStatus, " +
            "b.partLabelStatus, b.MIRN_Url, b.qualityCheckUrl, b.partLabelUrl, b.lotSize, b.containerCount, " +
            "b.shippingLoc, b.createdAt, b.updatedAt, " +
            "b.model.modelId, b.project.projectId, b.endCustomer.endCustomerId, " +
            "b.originCustomer.originCustomerId, b.createdBy.userId, b.updatedBy.userId) " +
            "FROM BomTable b WHERE b.bomTableId = :bomTableId")
    Optional<BomTableDTO> DTOfindByBomTableId(@Param("bomTableId") String bomTableId);

    @Query("SELECT new com.spaceage.logistics.Payload.DTO.BomTableDTO(" +
            "b.bomTableId, b.lotRefNo, b.partCount, b.mirnPartCount, b.pendingForPickupPartCount, " +
            "b.acknowledgedPartCount, b.qcFailedPartCount, b.partlabelPartCount, b.bomcompletePartCount, " +
            "b.errorPartCount, b.s3Location, b.s3Key, b.status, b.acknowledgementStatus, b.qualityCheckStatus, " +
            "b.partLabelStatus, b.MIRN_Url, b.qualityCheckUrl, b.partLabelUrl, b.lotSize, b.containerCount, " +
            "b.shippingLoc, b.createdAt, b.updatedAt, " +
            "b.model.modelId, b.project.projectId, b.endCustomer.endCustomerId, " +
            "b.originCustomer.originCustomerId, b.createdBy.userId, b.updatedBy.userId) " +
            "FROM BomTable b WHERE b.status = :status AND b.createdBy.userId = :userId")
    List<BomTableDTO> DTOfindByStatusAndUserId(@Param("status") BomTableStatus status, @Param("userId") String userId);

    @Query("SELECT new com.spaceage.logistics.Payload.DTO.BomTableDTO(" +
            "b.bomTableId, b.lotRefNo, b.partCount, b.mirnPartCount, b.pendingForPickupPartCount, " +
            "b.acknowledgedPartCount, b.qcFailedPartCount, b.partlabelPartCount, b.bomcompletePartCount, " +
            "b.errorPartCount, b.s3Location, b.s3Key, b.status, b.acknowledgementStatus, b.qualityCheckStatus, " +
            "b.partLabelStatus, b.MIRN_Url, b.qualityCheckUrl, b.partLabelUrl, b.lotSize, b.containerCount, " +
            "b.shippingLoc, b.createdAt, b.updatedAt, " +
            "b.model.modelId, b.project.projectId, b.endCustomer.endCustomerId, " +
            "b.originCustomer.originCustomerId, b.createdBy.userId, b.updatedBy.userId) " +
            "FROM BomTable b WHERE b.status IN (:statuses) AND b.createdBy.userId = :userId")
    List<BomTableDTO> DTOfindByStatusesAndUserId(@Param("statuses") List<BomTableStatus> statuses, @Param("userId") String userId);

    @Query("SELECT b FROM BomTable b WHERE b.status IN :statusList")
    Page<BomTable> findByStatusList(@Param("statusList") List<BomTableStatus> statusList, Pageable pageable);


//    Page<BomTable> findByStatusInAndCreatedAtIsNotNull(List<BomTableStatus> list, Pageable pageable);
}
