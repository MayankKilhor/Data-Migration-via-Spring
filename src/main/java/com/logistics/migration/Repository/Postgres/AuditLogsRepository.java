package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.Logs.AuditLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogsRepository extends JpaRepository<AuditLogs, Long> {

}
