package com.nmb.bancassurance.payments.services;

import com.nmb.bancassurance.payments.dtos.PaymentDTO;
import com.nmb.bancassurance.shared.dtos.APIResponder;
import jakarta.servlet.http.HttpServletRequest;

public interface PaymentService {

    APIResponder.Paginated<PaymentDTO> fetchPayments(HttpServletRequest servletRequest);
}
