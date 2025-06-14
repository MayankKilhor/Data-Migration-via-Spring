package com.logistics.migration.Repository.Postgres;

import com.logistics.migration.Model.Postgres.Uploading.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

}
