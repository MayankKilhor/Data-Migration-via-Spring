package com.spaceage.logistics.Repository.MySQL;


import com.spaceage.logistics.Model.MySQL.CustomerMaster;
import com.spaceage.logistics.Model.MySQL.ItemMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, Integer> {


    @Query("SELECT i FROM ItemMaster i WHERE i.createdDate < :cutoff")
    List<ItemMaster> findItemsCreatedBefore(@Param("cutoff") LocalDateTime cutoff);

}
