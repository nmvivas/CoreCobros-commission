// com.banquito.cobros.commission.repository.PayCommRecordRepository.java
package com.banquito.cobros.commission.repository;

import com.banquito.cobros.commission.model.PaymentCommissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayCommRecordRepository extends JpaRepository<PaymentCommissionRecord, Long> {
}