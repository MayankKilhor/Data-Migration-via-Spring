package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.Pallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalletRepository extends JpaRepository<Pallet, String> {


}
