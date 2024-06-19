package com.banquito.cobros.commission.util.mapper;

import com.banquito.cobros.commission.dto.CommissionDTO;
import com.banquito.cobros.commission.model.Commission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommissionMapper {
    CommissionMapper INSTANCE = Mappers.getMapper(CommissionMapper.class);

    CommissionDTO toDTO(Commission commission);

    Commission toEntity(CommissionDTO commissionDTO);
}