package com.nmb.bancassurance.payments.controllers;

import com.nmb.bancassurance.payments.dtos.PaymentDTO;
import com.nmb.bancassurance.payments.services.PaymentService;
import com.nmb.bancassurance.shared.dtos.APIResponder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public APIResponder.Paginated<PaymentDTO> fetchPayments(HttpServletRequest servletRequest) {
        return paymentService.fetchPayments(servletRequest);
    }
}
