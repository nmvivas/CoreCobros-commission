package com.banquito.cobros.commission.service;

import com.banquito.cobros.commission.dto.ReceivableCommissionDTO;
import com.banquito.cobros.commission.model.ReceivableCommission;
import com.banquito.cobros.commission.repository.ReceivableCommissionRepository;
import com.banquito.cobros.commission.util.mapper.ReceivableCommissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceivableCommissionService {

    private final ReceivableCommissionRepository receivableCommissionRepository;
    private final ReceivableCommissionMapper receivableCommissionMapper;

    public ReceivableCommissionService(ReceivableCommissionRepository receivableCommissionRepository) {
        this.receivableCommissionRepository = receivableCommissionRepository;
        this.receivableCommissionMapper = ReceivableCommissionMapper.INSTANCE;
    }

    public List<ReceivableCommissionDTO> getAllReceivablesCommissions() {
        List<ReceivableCommission> receivableCommissions = receivableCommissionRepository.findAll();
        return receivableCommissions.stream()
                .map(receivableCommissionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ReceivableCommissionDTO> getReceivablesCommissionById(Long id) {
        Optional<ReceivableCommission> receivableCommission = receivableCommissionRepository.findById(id);
        return receivableCommission.map(receivableCommissionMapper::toDTO);
    }

    public ReceivableCommissionDTO saveReceivablesCommission(ReceivableCommissionDTO receivablesCommissionDTO) {
        ReceivableCommission receivableCommission = receivableCommissionMapper.toEntity(receivablesCommissionDTO);
        ReceivableCommission savedReceivableCommission = receivableCommissionRepository.save(receivableCommission);
        return receivableCommissionMapper.toDTO(savedReceivableCommission);
    }

    public void deleteReceivablesCommission(Long id) {
        receivableCommissionRepository.deleteById(id);
    }
}
