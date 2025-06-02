package com.logistics.migration.Repository.Postgres;

import com.logistics.migration.Model.Postgres.Logs.ActivityLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActivityLogsRepository extends JpaRepository<ActivityLogs, Long> {

    List<ActivityLogs> findByUsernameAndTimestampGmtBetween(String username, Date startTime, Date endTime);
//    List<ActivityLogs> findByBomTableIdAndTimestampGmtBetween(String bomTableId, Date startTime, Date endTime);

}
