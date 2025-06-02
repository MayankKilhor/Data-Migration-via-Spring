package com.spaceage.logistics.Repository.Postgres;


import com.spaceage.logistics.Model.Postgres.Logs.AuditLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogsRepository extends JpaRepository<AuditLogs, Long> {

}
