package com.rsl.mspayment.client;

import com.rsl.mspayment.exception.ExceptionResponseFeign;
import com.rsl.mspayment.model.ExceptionConstants;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-card", url = "${client.ms-card.endpoint}")
public interface CardClient {

    @GetMapping("/api/cards")
    List<CardDto> getAllAvailable(@RequestParam String currency);



}
