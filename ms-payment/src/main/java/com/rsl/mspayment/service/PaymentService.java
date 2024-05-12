package com.rsl.mspayment.service;

import com.rsl.mspayment.client.CardClient;
import com.rsl.mspayment.client.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final CardClient cardClient;
    public List<CardDto> getAllAvailableCards(String currency){
        return cardClient.getAllAvailable(currency);
    }
}
