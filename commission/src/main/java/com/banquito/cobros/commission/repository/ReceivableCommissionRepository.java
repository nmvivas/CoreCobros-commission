package com.banquito.cobros.commission.repository;

import com.banquito.cobros.commission.model.ReceivableCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceivableCommissionRepository extends JpaRepository<ReceivableCommission, Long> {
    List<ReceivableCommission> findByReceivableId(Long receivableId);
}
