package com.rsl.mspayment.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.UnexpectedException;

import static com.rsl.mspayment.model.ExceptionConstants.*;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleInternal(Exception exception){
        log.error("Exception: {}", exception.getMessage());
        return new ExceptionResponse(UNEXPECTED_EXCEPTION_CODE, UNEXPECTED_EXCEPTION_MESSAGE);
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleInternal(NotFoundException exception){
        log.error("NotFoundException: {}", exception.getMessage());
        return new ExceptionResponse(exception.getCode(), exception.getMessage());
    }


    @ExceptionHandler(UndeclaredThrowableException.class) //InvocationTargetException
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ExceptionResponse handleServiceUnavailable(UndeclaredThrowableException e){
        log.error("UndeclaredThrowableException: {}", e.getMessage());
        return new ExceptionResponse(HttpStatus.SERVICE_UNAVAILABLE.name(), e.getCause().getCause().getMessage());
    }

    @ExceptionHandler(ExceptionResponseFeign.class) //InvocationTargetException
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ExceptionResponse handleServiceUnavailable(ExceptionResponseFeign e){
        log.error("ExceptionResponseFeign: {}", e.getMessage());
        return new ExceptionResponse(HttpStatus.SERVICE_UNAVAILABLE.name(), e.getMessage());
    }
}
