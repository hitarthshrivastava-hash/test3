package com.api_nov.exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String message){
        super(message);
    }
}
