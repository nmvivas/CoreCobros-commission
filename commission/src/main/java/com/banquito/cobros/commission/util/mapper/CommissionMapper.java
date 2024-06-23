package com.banquito.cobros.commission.util.mapper;

import com.banquito.cobros.commission.dto.CommissionDTO;
import com.banquito.cobros.commission.model.Commission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ReceivableCommissionMapper.class)
public interface CommissionMapper {
    CommissionMapper INSTANCE = Mappers.getMapper(CommissionMapper.class);

    @Mapping(source = "receivablesCommission", target = "receivablesCommission")
    CommissionDTO toDTO(Commission commission);

    @Mapping(source = "receivablesCommission", target = "receivablesCommission")
    Commission toEntity(CommissionDTO commissionDTO);

    void updateEntityFromDTO(CommissionDTO dto, @MappingTarget Commission entity);
}
