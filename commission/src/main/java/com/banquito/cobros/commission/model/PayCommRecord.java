package com.banquito.cobros.commission.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
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
@Table(name = "PAYMENT_COMMISSION_RECORD")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PayCommRecord implements Serializable {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMISSION_ID", referencedColumnName = "COMMISSION_ID", insertable = false, updatable = false)
    private Commission commission;

    public PayCommRecord(Long id) {
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
        PayCommRecord other = (PayCommRecord) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
