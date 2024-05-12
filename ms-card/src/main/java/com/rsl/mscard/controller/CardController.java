package com.rsl.mscard.controller;

import com.rsl.mscard.model.CardDto;
import com.rsl.mscard.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<CardDto> getAllAvailableCards(@RequestParam String currency){
        return cardService.getAllAvailableCards(currency);
    }

}
