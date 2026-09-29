package com.example.busspass.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice                //make the class as global interceptor thta  catches exption thrown in controller and covert into HTTP repsonse
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)    //it tells spring whenever the BusinessException happens come here and get the message
    public ResponseEntity<String> handleBusinessException(BusinessException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),    //getting the message
                HttpStatus.BAD_REQUEST
        );
    }
}