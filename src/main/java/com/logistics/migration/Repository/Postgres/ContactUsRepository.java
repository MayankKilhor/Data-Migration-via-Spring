package com.logistics.migration.Repository.Postgres;


import com.logistics.migration.Model.Postgres.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {
}