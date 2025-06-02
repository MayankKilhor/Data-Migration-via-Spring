package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.Uploading.BomUploadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomUploadStatusRepository extends JpaRepository<BomUploadStatus, String> {

}
