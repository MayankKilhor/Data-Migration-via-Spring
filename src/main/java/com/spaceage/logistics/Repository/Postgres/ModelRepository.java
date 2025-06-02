package com.spaceage.logistics.Repository.Postgres;


import com.spaceage.logistics.Model.Postgres.Uploading.Model;
import com.spaceage.logistics.Model.Postgres.Uploading.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

    Optional<Model> findByModelIdAndProject(String modelId, Project project);




        @Query("SELECT m FROM Model m WHERE m.modelId LIKE :modelIdPattern")
        Optional<Model> findByModelIdPattern(@Param("modelIdPattern") String modelIdPattern);


}
