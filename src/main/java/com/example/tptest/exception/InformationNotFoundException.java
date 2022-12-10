package com.example.tptest.exception;

public class InformationNotFoundException extends RuntimeException{

    public InformationNotFoundException(String message) {
        super(message);
    }
}
