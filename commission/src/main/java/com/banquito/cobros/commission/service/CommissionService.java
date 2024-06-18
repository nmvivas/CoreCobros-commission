package com.banquito.cobros.commission.service;

import com.banquito.cobros.commission.model.Commission;
import com.banquito.cobros.commission.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    public List<Commission> getAllCommissions() {
        return commissionRepository.findAll();
    }

    public Optional<Commission> getCommissionById(Long id) {
        return commissionRepository.findById(id);
    }

    public Commission saveCommission(Commission commission) {
        return commissionRepository.save(commission);
    }

    public void deleteCommission(Long id) {
        commissionRepository.deleteById(id);
    }
}
