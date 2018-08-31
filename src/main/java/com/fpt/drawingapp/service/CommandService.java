package com.fpt.drawingapp.service;

import com.fpt.drawingapp.model.Canvas;

public interface CommandService {

    void handle(final String inputValue, final Canvas canvas);
}