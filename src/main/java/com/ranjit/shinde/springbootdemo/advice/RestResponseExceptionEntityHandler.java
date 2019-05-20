package com.ranjit.shinde.springbootdemo.advice;

import com.ranjit.shinde.springbootdemo.exception.MovieNotFoundException;
import com.ranjit.shinde.springbootdemo.model.ErrorMessage;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.http.entity.ContentType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Map;

@ControllerAdvice
public class RestResponseExceptionEntityHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(MovieNotFoundException.class)
    protected ResponseEntity<Object> handleConflict(MovieNotFoundException exception,
                                                    WebRequest request){

//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");

        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    public ResponseEntity<String> handleConflict(ConstraintViolationException ex, WebRequest request) {
        String message = ex.getMessage()+ " cannot be empty";
        return new ResponseEntity < > (message, null, HttpStatus.BAD_REQUEST);
    }
}
