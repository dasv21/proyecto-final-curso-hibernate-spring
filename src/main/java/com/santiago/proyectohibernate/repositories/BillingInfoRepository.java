package com.santiago.proyectohibernate.repositories;

import com.santiago.proyectohibernate.entities.BillingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingInfoRepository extends JpaRepository<BillingInfo, Long> {
}
