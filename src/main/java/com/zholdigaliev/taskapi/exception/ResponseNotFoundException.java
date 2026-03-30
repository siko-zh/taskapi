package com.zholdigaliev.taskapi.exception;

public class ResponseNotFoundException extends RuntimeException{
    public ResponseNotFoundException(String message) {
        super(message);
    }
}
