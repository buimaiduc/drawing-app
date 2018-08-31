package com.fpt.drawingapp.exception;

public class BaseException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;
    private final transient Object details;

    public BaseException() {
        this.errorMessage = null;
        this.errorCode = null;
        this.details = null;
    }

    public BaseException(String errorCode, String message) {
        super(message);
        this.errorMessage = message;
        this.errorCode = errorCode;
        this.details = null;
    }

    public BaseException(String errorCode, String message, Object details) {
        super(message);
        this.errorMessage = message;
        this.errorCode = errorCode;
        this.details = details;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Object getDetails() {
        return this.details;
    }
}