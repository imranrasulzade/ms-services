package com.rsl.mspayment.mapper;

import com.rsl.mspayment.entities.Payment;
import com.rsl.mspayment.model.dto.request.PaymentRequest;
import com.rsl.mspayment.model.dto.response.PaymentResponse;

import java.time.LocalDateTime;

public class PaymentMapper {

    public static Payment mapToEntity(PaymentRequest paymentRequest){
        return Payment.builder()
                .amount(paymentRequest.getAmount())
                .description(paymentRequest.getDescription())
                .status(paymentRequest.getStatus())
                .build();
    }

    public static PaymentResponse mapToDTO(Payment payment){
        return PaymentResponse.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .description(payment.getDescription())
                .status(payment.getStatus())
                .responseAt(LocalDateTime.now())
                .build();
    }

}
