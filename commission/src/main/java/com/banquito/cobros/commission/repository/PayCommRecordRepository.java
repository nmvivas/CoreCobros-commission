// com.banquito.cobros.commission.repository.PayCommRecordRepository.java
package com.banquito.cobros.commission.repository;

import com.banquito.cobros.commission.model.PayCommRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayCommRecordRepository extends JpaRepository<PayCommRecord, Long> {
}