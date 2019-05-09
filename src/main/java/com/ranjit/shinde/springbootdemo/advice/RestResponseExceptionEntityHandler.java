package com.ranjit.shinde.springbootdemo.advice;

import com.ranjit.shinde.springbootdemo.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.jws.WebResult;

@ControllerAdvice
public class RestResponseExceptionEntityHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(MovieNotFoundException.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException exception,
                                                    WebRequest request){

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

    }
}
