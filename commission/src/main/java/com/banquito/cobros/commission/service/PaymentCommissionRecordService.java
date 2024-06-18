package com.banquito.cobros.commission.service;

import com.banquito.cobros.commission.model.PaymentCommissionRecord;
import com.banquito.cobros.commission.repository.PayCommRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentCommissionRecordService {

    @Autowired
    private PayCommRecordRepository payCommRecordRepository;

    public List<PaymentCommissionRecord> getAllPayCommRecords() {
        return payCommRecordRepository.findAll();
    }

    public Optional<PaymentCommissionRecord> getPayCommRecordById(Long id) {
        return payCommRecordRepository.findById(id);
    }

    public PaymentCommissionRecord savePayCommRecord(PaymentCommissionRecord payCommRecord) {
        return payCommRecordRepository.save(payCommRecord);
    }

    public void deletePayCommRecord(Long id) {
        payCommRecordRepository.deleteById(id);
    }
}
