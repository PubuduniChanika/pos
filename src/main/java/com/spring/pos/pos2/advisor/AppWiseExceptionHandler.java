package com.spring.pos.pos2.advisor;

import com.spring.pos.pos2.exception.NotFoundException;
import com.spring.pos.pos2.util.mappers.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWiseExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"No Customers Available",e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
