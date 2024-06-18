package com.banquito.cobros.commission.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RECEIVABLES_COMMISSION")
public class ReceivablesCommission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECEIVABLES_COMMISSION_ID", nullable = false)
    private Long id;

    @Column(name = "RECEIVABLES_ID", nullable = false)
    private Long receivablesId;

    @ManyToOne
    @JoinColumn(name = "COMMISSION_ID", nullable = false)
    private Commission commission;

    public ReceivablesCommission() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceivablesId() {
        return receivablesId;
    }

    public void setReceivablesId(Long receivablesId) {
        this.receivablesId = receivablesId;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public Long getCommissionId() {
        return this.commission != null ? this.commission.getId() : null;
    }

    public void setCommissionId(Long commissionId) {
        if (this.commission == null) {
            this.commission = new Commission();
        }
        this.commission.setId(commissionId);
    }

    @Override
    public String toString() {
        return "ReceivablesCommission [id=" + id + ", commission=" + commission + ", receivablesId=" + receivablesId
                + "]";
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
        ReceivablesCommission other = (ReceivablesCommission) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
