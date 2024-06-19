package com.banquito.cobros.commission.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "COMMISSION")
public class Commission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMISSION_ID", nullable = false)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "CHARGE_DISTRIBUTION", length = 3, nullable = false)
    private String chargeDistribution;

    @Column(name = "TOTAL_VALUE", precision = 17, scale = 2, nullable = false)
    private BigDecimal totalValue;

    @Column(name = "COMPANY_VALUE", precision = 17, scale = 2, nullable = false)
    private BigDecimal companyValue;

    @Column(name = "DEBTOR_VALUE", precision = 17, scale = 2, nullable = false)
    private BigDecimal debtorValue;

    @Column(name = "CREDITOR_ACCOUNT", length = 13, nullable = false)
    private String creditorAccount;

    // @Column(name = "COMPANY_ID", nullable = false)
    // private Long companyId;

    @OneToMany(mappedBy = "commission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReceivablesCommission> receivablesCommission;

    public Commission() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChargeDistribution() {
        return chargeDistribution;
    }

    public void setChargeDistribution(String chargeDistribution) {
        this.chargeDistribution = chargeDistribution;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getCompanyValue() {
        return companyValue;
    }

    public void setCompanyValue(BigDecimal companyValue) {
        this.companyValue = companyValue;
    }

    public BigDecimal getDebtorValue() {
        return debtorValue;
    }

    public void setDebtorValue(BigDecimal debtorValue) {
        this.debtorValue = debtorValue;
    }

    public String getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(String creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    // public Long getCompanyId() {
    // return companyId;
    // }

    // public void setCompanyId(Long companyId) {
    // this.companyId = companyId;
    // }

    public List<ReceivablesCommission> getReceivablesCommission() {
        return receivablesCommission;
    }

    public void setReceivablesCommission(List<ReceivablesCommission> receivablesCommission) {
        this.receivablesCommission = receivablesCommission;
    }

    @Override
    public String toString() {
        return "Commission [id=" + id + ", name=" + name + ", chargeDistribution=" + chargeDistribution +
                ", totalValue=" + totalValue + ", companyValue=" + companyValue + ", debtorValue=" + debtorValue +
                ", creditorAccount=" + creditorAccount + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Commission other = (Commission) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
