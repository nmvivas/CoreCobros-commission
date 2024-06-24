package com.banquito.cobros.commission.service;

import com.banquito.cobros.commission.model.PayCommRecord;
import com.banquito.cobros.commission.repository.PayCommRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayCommRecordService {

    @Autowired
    private PayCommRecordRepository payCommRecordRepository;

    public List<PayCommRecord> getAllPayCommRecords() {
        return payCommRecordRepository.findAll();
    }

    public Optional<PayCommRecord> getPayCommRecordById(Long id) {
        return payCommRecordRepository.findById(id);
    }

    public PayCommRecord savePayCommRecord(PayCommRecord payCommRecord) {
        return payCommRecordRepository.save(payCommRecord);
    }
}
