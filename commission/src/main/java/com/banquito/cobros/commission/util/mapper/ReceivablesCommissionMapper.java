package com.banquito.cobros.commission.util.mapper;

import com.banquito.cobros.commission.dto.ReceivablesCommissionDTO;
import com.banquito.cobros.commission.model.ReceivablesCommission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceivablesCommissionMapper {
    ReceivablesCommissionMapper INSTANCE = Mappers.getMapper(ReceivablesCommissionMapper.class);

    @Mapping(source = "commission.id", target = "commissionId")
    ReceivablesCommissionDTO toDTO(ReceivablesCommission receivablesCommission);

    @Mapping(source = "commissionId", target = "commission.id")
    ReceivablesCommission toEntity(ReceivablesCommissionDTO receivablesCommissionDTO);
}
