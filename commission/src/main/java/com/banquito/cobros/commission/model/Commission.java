package com.banquito.cobros.commission.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "COMMISSION")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

    @OneToMany(mappedBy = "commission", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ReceivableCommission> receivableCommission;

    @OneToMany(mappedBy = "commission", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PayCommRecord> payCommRecords;

    public Commission(Long id) {
        this.id = id;
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
