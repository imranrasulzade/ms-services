package com.rsl.mspayment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-card", url = "${client.ms-card.endpoint}")
public interface CardClient {

    @GetMapping("/api/cards")
    List<CardDto> getAllAvailable(@RequestParam String currency);

}
