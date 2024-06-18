package com.banquito.cobros.commission.service;

import com.banquito.cobros.commission.model.ReceivablesCommission;
import com.banquito.cobros.commission.repository.ReceivablesCommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceivablesCommissionService {

    @Autowired
    private ReceivablesCommissionRepository receivablesCommissionRepository;

    public List<ReceivablesCommission> getAllReceivablesCommissions() {
        return receivablesCommissionRepository.findAll();
    }

    public Optional<ReceivablesCommission> getReceivablesCommissionById(Long id) {
        return receivablesCommissionRepository.findById(id);
    }

    public ReceivablesCommission saveReceivablesCommission(ReceivablesCommission receivablesCommission) {
        return receivablesCommissionRepository.save(receivablesCommission);
    }

    public void deleteReceivablesCommission(Long id) {
        receivablesCommissionRepository.deleteById(id);
    }
}
