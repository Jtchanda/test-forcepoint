package com.nmb.bancassurance.payments.models;

import com.nmb.bancassurance.payments.dtos.PaymentDTO;
import com.nmb.bancassurance.shared.models.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
public class Payment extends BaseModel<PaymentDTO> {
    @Override
    public PaymentDTO toDTO() {
        return PaymentDTO.builder()
                .id(getId())
                .build();
    }

    @Override
    public String toAuditTrailDetail() {
        return "";
    }
}
