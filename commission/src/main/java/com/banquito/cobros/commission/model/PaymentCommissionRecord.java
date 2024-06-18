package com.banquito.cobros.commission.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PAYMENT_COMMISSION_RECORD")
public class PaymentCommissionRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_COMMISSION_ID", nullable = false)
    private Long id;

    @Column(name = "COMMISSION_ID", nullable = false)
    private Integer commissionId;

    @Column(name = "PAYMENT_RECORD_ID", nullable = false)
    private Integer paymentRecordId;

    @Column(name = "NOTE", length = 250)
    private String note;

    public PaymentCommissionRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Integer commissionId) {
        this.commissionId = commissionId;
    }

    public Integer getPaymentRecordId() {
        return paymentRecordId;
    }

    public void setPaymentRecordId(Integer paymentRecordId) {
        this.paymentRecordId = paymentRecordId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PayCommRecord [id=" + id + ", commissionId=" + commissionId + ", paymentRecordId=" + paymentRecordId
                + ", note=" + note + "]";
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
        PaymentCommissionRecord other = (PaymentCommissionRecord) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
