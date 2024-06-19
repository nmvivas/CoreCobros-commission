package com.banquito.cobros.commission.service;

import com.banquito.cobros.commission.dto.ReceivablesCommissionDTO;
import com.banquito.cobros.commission.model.ReceivablesCommission;
import com.banquito.cobros.commission.repository.ReceivablesCommissionRepository;
import com.banquito.cobros.commission.util.mapper.ReceivablesCommissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceivablesCommissionService {

    private final ReceivablesCommissionRepository receivablesCommissionRepository;
    private final ReceivablesCommissionMapper receivablesCommissionMapper;

    public ReceivablesCommissionService(ReceivablesCommissionRepository receivablesCommissionRepository) {
        this.receivablesCommissionRepository = receivablesCommissionRepository;
        this.receivablesCommissionMapper = ReceivablesCommissionMapper.INSTANCE;
    }

    public List<ReceivablesCommissionDTO> getAllReceivablesCommissions() {
        List<ReceivablesCommission> receivablesCommissions = receivablesCommissionRepository.findAll();
        return receivablesCommissions.stream()
                .map(receivablesCommissionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ReceivablesCommissionDTO> getReceivablesCommissionById(Long id) {
        Optional<ReceivablesCommission> receivablesCommission = receivablesCommissionRepository.findById(id);
        return receivablesCommission.map(receivablesCommissionMapper::toDTO);
    }

    public ReceivablesCommissionDTO saveReceivablesCommission(ReceivablesCommissionDTO receivablesCommissionDTO) {
        ReceivablesCommission receivablesCommission = receivablesCommissionMapper.toEntity(receivablesCommissionDTO);
        ReceivablesCommission savedReceivablesCommission = receivablesCommissionRepository.save(receivablesCommission);
        return receivablesCommissionMapper.toDTO(savedReceivablesCommission);
    }

    public void deleteReceivablesCommission(Long id) {
        receivablesCommissionRepository.deleteById(id);
    }
}
