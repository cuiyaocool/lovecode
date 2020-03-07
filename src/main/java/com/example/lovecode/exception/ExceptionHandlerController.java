package com.example.lovecode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = TestException.class)
    public ResponseEntity doTestException(TestException e) {
        return new ResponseEntity(e.msg, HttpStatus.ACCEPTED);
    }
}
