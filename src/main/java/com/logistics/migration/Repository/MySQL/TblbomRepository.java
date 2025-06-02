package com.logistics.migration.Repository.MySQL;



import com.logistics.migration.Model.MySQL.Tblbom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblbomRepository extends JpaRepository<Tblbom, Integer> {

    List<Tblbom> findByItemId(Integer itemId);

}
