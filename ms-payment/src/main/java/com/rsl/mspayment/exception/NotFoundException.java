package com.rsl.mspayment.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotFoundException extends RuntimeException{
    private final String code;

    public NotFoundException(String message, String code){
        super(message);
        this.code = code;
    }

}
