package com.logistics.migration.Repository.Postgres;

import com.logistics.migration.Model.Postgres.Uploading.BomUploadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomUploadStatusRepository extends JpaRepository<BomUploadStatus, String> {

}
