package com.fpt.drawingapp.service;

public interface DrawService<INPUT, OUTPUT> {

    void validate(final INPUT input, final OUTPUT output);

    OUTPUT draw(final INPUT input, final OUTPUT output);
}
