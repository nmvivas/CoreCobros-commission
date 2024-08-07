package com.banquito.cobros.commission.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class CommissionDTO {

    private Long id;
    private String name;
    private String chargeDistribution;
    private BigDecimal totalValue;
    private BigDecimal companyValue;
    private BigDecimal debtorValue;
    private String creditorAccount;
    private List<ReceivableCommissionDTO> receivableCommission;
}
