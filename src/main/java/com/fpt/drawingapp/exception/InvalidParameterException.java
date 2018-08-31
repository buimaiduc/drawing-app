package com.fpt.drawingapp.exception;

public class InvalidParameterException extends BaseException {
    private static final long serialVersionUID = 6319701242162237710L;

    public InvalidParameterException(String message) {
        super("41002", message);
    }
}
