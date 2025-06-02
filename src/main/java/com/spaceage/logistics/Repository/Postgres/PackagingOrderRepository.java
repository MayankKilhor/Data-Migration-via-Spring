package com.spaceage.logistics.Repository.Postgres;

import com.spaceage.logistics.Model.Postgres.PackagingOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PackagingOrderRepository extends JpaRepository<PackagingOrder, String> {


}
