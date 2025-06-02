package com.logistics.migration.Repository.MySQL;


import com.logistics.migration.Model.MySQL.ProjectMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectMasterRepository extends JpaRepository<ProjectMaster, Integer> {

    Optional<ProjectMaster> findByProjectName(String projectName);

}
