package com.banquito.cobros.commission.repository;

import com.banquito.cobros.commission.model.ReceivableCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivableCommissionRepository extends JpaRepository<ReceivableCommission, Long> {

}