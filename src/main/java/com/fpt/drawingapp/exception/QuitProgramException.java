package com.fpt.drawingapp.exception;

public class QuitProgramException extends BaseException {
    private static final long serialVersionUID = 6319701242162237710L;

    public QuitProgramException(String message) {
        super("41003", message);
    }
}
