package com.rsl.mscard.service;

import com.rsl.mscard.model.CardDto;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    public List<CardDto> getAllAvailableCards(String currency){
        if(currency.equals("AZN")){
            return List.of((new CardDto(1L, "4169********1111", Year.now(), Month.APRIL, 1)),
                    (new CardDto(2L, "5548********0000", Year.now(), Month.MARCH, 1)));
        }

        return new ArrayList<>();
    }
}
