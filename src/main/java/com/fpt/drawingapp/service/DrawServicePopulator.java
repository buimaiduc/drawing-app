package com.fpt.drawingapp.service;

@SuppressWarnings("unchecked")
public final class DrawServicePopulator<INPUT, OUTPUT> {

    public final String populate(final DrawService drawService, final INPUT input, final OUTPUT output) {
        // validate input, output
        drawService.validate(input, output);

        // draw output
        drawService.draw(input, output);

        return output.toString();
    }
}
