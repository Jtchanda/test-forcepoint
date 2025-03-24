package com.nmb.bancassurance.payments.services.implementors;

import com.nmb.bancassurance.payments.dtos.PaymentDTO;
import com.nmb.bancassurance.payments.models.Payment;
import com.nmb.bancassurance.payments.repository.PaymentRepository;
import com.nmb.bancassurance.payments.services.PaymentService;
import com.nmb.bancassurance.shared.dtos.APIResponder;
import com.nmb.bancassurance.shared.dtos.PaginatedData;
import com.nmb.bancassurance.shared.services.implementors.BaseServiceImplementor;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImplementor extends BaseServiceImplementor implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public APIResponder.Paginated<PaymentDTO> fetchPayments(HttpServletRequest servletRequest) {
        return paginatedAPIResponse(() -> {
            PaginatedData.Request request = PaginatedData.Request.fromServlet(servletRequest);
            Page<Payment> payments = paymentRepository.findAll(request.toPageable());
            PaginatedData<PaymentDTO> paginatedData = request.toPaginatedData(payments);
            return APIResponder.ok("Payments Fetched Successfully", paginatedData);
        });
    }
}
