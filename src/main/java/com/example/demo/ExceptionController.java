package com.example.demo;


import org.hibernate.JDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = JDBCException.class)
    public ResponseEntity<Object> exception(JDBCException ex)
    {
        return new ResponseEntity<>("Oracle Problem", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
