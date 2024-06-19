package com.banquito.cobros.commission.util.mapper;

import com.banquito.cobros.commission.dto.ReceivablesCommissionDTO;
import com.banquito.cobros.commission.model.ReceivablesCommission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceivablesCommissionMapper {
    ReceivablesCommissionMapper INSTANCE = Mappers.getMapper(ReceivablesCommissionMapper.class);

    ReceivablesCommissionDTO toDTO(ReceivablesCommission receivablesCommission);

    ReceivablesCommission toEntity(ReceivablesCommissionDTO receivablesCommissionDTO);
}