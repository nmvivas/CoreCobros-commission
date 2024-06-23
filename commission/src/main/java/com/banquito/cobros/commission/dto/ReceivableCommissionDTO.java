package com.banquito.cobros.commission.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReceivableCommissionDTO {

    private Long id;
    private Long commissionId;
    private Long receivableId;
}
