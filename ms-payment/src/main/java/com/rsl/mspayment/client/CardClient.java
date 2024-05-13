package com.rsl.mspayment.client;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "ms-card", url = "${client.ms-card.endpoint}")
public interface CardClient {

    List<CardDto> getAllAvailable(String currency);



}
