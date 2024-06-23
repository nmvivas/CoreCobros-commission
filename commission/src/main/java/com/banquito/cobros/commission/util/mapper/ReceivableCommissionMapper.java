package com.banquito.cobros.commission.util.mapper;

import com.banquito.cobros.commission.dto.ReceivableCommissionDTO;
import com.banquito.cobros.commission.model.ReceivableCommission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceivableCommissionMapper {
    ReceivableCommissionMapper INSTANCE = Mappers.getMapper(ReceivableCommissionMapper.class);

    @Mapping(source = "commission.id", target = "commissionId")
    ReceivableCommissionDTO toDTO(ReceivableCommission receivablesCommission);

    @Mapping(source = "commissionId", target = "commission.id")
    ReceivableCommission toEntity(ReceivableCommissionDTO receivablesCommissionDTO);
}
