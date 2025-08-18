package org.example.largefruitcompanyapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class FruitNotFoundAdvice {

    @ExceptionHandler(FruitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(FruitNotFoundException ex) {
        return ex.getMessage();
    }
}