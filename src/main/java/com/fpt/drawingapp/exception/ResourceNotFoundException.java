package com.fpt.drawingapp.exception;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException() {
        this("41001", (String) null);
    }

    public ResourceNotFoundException(String message) {
        this("41001", message);
    }

    public ResourceNotFoundException(String errorCode, String message) {
        super(errorCode, message);
    }
}