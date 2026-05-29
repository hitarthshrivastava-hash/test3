package com.api_nov.exception;

import com.api_nov.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
     public ResponseEntity<ErrorDto> runtimeExceptionHandler(
             RuntimeException e,
             WebRequest request
     ){
        ErrorDto error = new ErrorDto();
        error.setMessage((e.getMessage()));
        error.setUrl(request.getDescription(true));
         return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
     }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorDto> recordNotFoundExceptionHandler(
            RecordNotFoundException e,
            WebRequest request
    ){
        ErrorDto error = new ErrorDto();
        error.setMessage((e.getMessage()));
        error.setUrl(request.getDescription(true));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
