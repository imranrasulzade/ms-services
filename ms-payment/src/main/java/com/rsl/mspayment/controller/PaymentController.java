package com.rsl.mspayment.controller;

import com.rsl.mspayment.client.CardDto;
import com.rsl.mspayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public String get() {
        return "Hello from MS-PAYMENT";
    }


    @GetMapping("/cards")
    public List<CardDto> getAllAvailableCards(@RequestParam String currency){
        return paymentService.getAllAvailableCards(currency);
    }
}
