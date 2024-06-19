package com.banquito.cobros.commission.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReceivablesCommissionDTO {

    private Long id;
    private Long commissionId;
    private Long receivablesId;
}
