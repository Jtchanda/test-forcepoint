package com.nmb.bancassurance.payments.repository;

import com.nmb.bancassurance.payments.models.Payment;
import com.nmb.bancassurance.shared.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends BaseRepository<Payment> {
}
