package com.logistics.migration.Repository.MySQL;



import com.logistics.migration.Model.MySQL.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Integer> {


}
