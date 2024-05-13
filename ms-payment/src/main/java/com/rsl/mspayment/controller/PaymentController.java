package com.rsl.mspayment.controller;

import com.rsl.mspayment.client.CardDto;
import com.rsl.mspayment.service.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public String get() {
        return "Hello from MS-PAYMENT";
    }

    @CircuitBreaker(name="external",fallbackMethod="TempData")
    @Retry(name="external",fallbackMethod = "TempData")
    @GetMapping("/cards")
    public List<CardDto> getAllAvailableCards(@RequestParam String currency){
        return paymentService.getAllAvailableCards(currency);
    }

    public List<CardDto> TempData(Exception e) {
        return Stream.of(new CardDto(1L, "000", Year.now(), Month.APRIL, 0))
                .collect(Collectors.toList());

    }
}
