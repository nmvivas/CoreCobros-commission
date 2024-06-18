package com.banquito.cobros.commission.repository;

import com.banquito.cobros.commission.model.ReceivablesCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivablesCommissionRepository extends JpaRepository<ReceivablesCommission, Long> {
}