package com.banquito.cobros.commission.service;

import com.banquito.cobros.commission.dto.CommissionDTO;
import com.banquito.cobros.commission.util.mapper.CommissionMapper;
import com.banquito.cobros.commission.model.Commission;
import com.banquito.cobros.commission.repository.CommissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommissionService {

    private final CommissionRepository commissionRepository;
    private final CommissionMapper commissionMapper;

    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
        this.commissionMapper = CommissionMapper.INSTANCE;
    }

    public List<CommissionDTO> getAllCommissions() {
        List<Commission> commissions = commissionRepository.findAll();
        return commissions.stream()
                .map(commissionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CommissionDTO> getCommissionById(Long id) {
        Optional<Commission> commission = commissionRepository.findById(id);
        return commission.map(commissionMapper::toDTO);
    }

    public CommissionDTO saveCommission(CommissionDTO commissionDTO) {
        Commission commission = commissionMapper.toEntity(commissionDTO);
        Commission savedCommission = commissionRepository.save(commission);
        return commissionMapper.toDTO(savedCommission);
    }

    public void deleteCommission(Long id) {
        commissionRepository.deleteById(id);
    }
}
